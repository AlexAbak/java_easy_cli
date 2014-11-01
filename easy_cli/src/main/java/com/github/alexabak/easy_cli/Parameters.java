/**
 * @author Алексей Кляузер <drum@pisem.net>
 * @version 0.0.1
 * @since 0.0.1
 */
package com.github.alexabak.easy_cli;

import java.lang.reflect.Field;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

/**
 * Родительский класс для простой работы с параметрами командной строки
 * @since 0.0.1
 */
public class Parameters {

	/**
	 * Опции командной строки
	 * @since 0.0.1
	 */
	private Options options;

	/**
	 * Конструктор
	 * @param args Аргументы командной строки
	 * @param r Пакет ресурсов для чтения описания
	 * @throws ParseException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @since 0.0.1
	 */
	public Parameters (String[] args, ResourceBundle r) throws ParseException, IllegalArgumentException, IllegalAccessException {
		Class<? extends Parameters> thisClass = this.getClass();
		if (r == null) {
			try {
				r = ResourceBundle.getBundle(thisClass.getCanonicalName().toLowerCase() + ".R");
			} catch (MissingResourceException e) {
				r = null;
			}
		}
		this.options = new Options();
		for (Field field : thisClass.getFields()) {
			if (field.isAnnotationPresent(Parameter.class)) {
				Parameter parameter = field.getAnnotation(Parameter.class);
				String description;
				if (r == null) {
					description = "";
				} else {
					description = r.getString(parameter.description());
				}
				this.options.addOption(
					parameter.shortName(),
					parameter.longName(),
					parameter.hasValue(),
					description
				);
			}
		};
		ParserKind.Kind kind;
		if (thisClass.isAnnotationPresent(ParserKind.class)) {
			ParserKind parserKind = thisClass.getAnnotation(ParserKind.class);
			kind = parserKind.kind();
		} else {
			kind = ParserKind.Kind.POSIX;
		}
		CommandLineParser parser;
		switch (kind) {
			case POSIX:
				parser = new PosixParser();
			break;
			case GNU:
				parser = new GnuParser();
			break;
			default:
				parser = new PosixParser();
		}
		CommandLine cmd = parser.parse(this.options, args);
		for (Field field : thisClass.getFields()) {
			if (field.isAnnotationPresent(Parameter.class)) {
				Parameter parameter = field.getAnnotation(Parameter.class);
				if (cmd.hasOption(parameter.shortName())) {
					if (!parameter.hasValue()) {
						field.setBoolean(this, true);
					} else {
						field.set(this, cmd.getOptionValue(parameter.shortName()));
					}
				} else {
					if (!parameter.hasValue()) {
						field.setBoolean(this, false);
					} else {
						field.set(this, null);
					}
				}
			}
		}
	}

	/**
	 * Отображение справки по параметрам командной строки
	 * @since 0.0.1
	 */
	public void printHelp () {
		String syntax;
		Class<? extends Parameters> thisClass = this.getClass();
		if (thisClass.isAnnotationPresent(ParserKind.class)) {
			ParserKind parserKind = thisClass.getAnnotation(ParserKind.class);
			syntax = parserKind.syntax();
		} else {
			syntax = "";
		}
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp(syntax, this.options);
	}

}

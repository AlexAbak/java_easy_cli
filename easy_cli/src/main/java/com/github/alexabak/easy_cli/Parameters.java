/**
 * Copyright © 2014. Все права защищены.
 * @author Моя неделя завершилась <https://myweek-end.ru/>
 * @author Алексей Кляузер <drum@pisem.net>
 *
 * This file is part of easy_cli.
 *
 * easy_cli is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * easy_cli is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with easy_cli.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Этот файл — часть easy_cli.
 *
 * easy_cli - свободная программа: вы можете перераспространять ее и/или
 * изменять ее на условиях Стандартной общественной лицензии GNU в том виде,
 * в каком она была опубликована Фондом свободного программного обеспечения;
 * либо версии 3 лицензии, либо (по вашему выбору) любой более поздней
 * версии.
 *
 * easy_cli распространяется в надежде, что она будет полезной,
 * но БЕЗО ВСЯКИХ ГАРАНТИЙ; даже без неявной гарантии ТОВАРНОГО ВИДА
 * или ПРИГОДНОСТИ ДЛЯ ОПРЕДЕЛЕННЫХ ЦЕЛЕЙ. Подробнее см. в Стандартной
 * общественной лицензии GNU.
 *
 * Вы должны были получить копию Стандартной общественной лицензии GNU
 * вместе с этой программой. Если это не так, см.
 * <http://www.gnu.org/licenses/>.
 * 
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

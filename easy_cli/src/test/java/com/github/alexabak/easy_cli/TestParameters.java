/**
 * @author Алексей Кляузер <drum@pisem.net>
 * @version 0.0.1
 * @since 0.0.1
 */
package com.github.alexabak.easy_cli;

import java.util.ResourceBundle;

import org.apache.commons.cli.ParseException;

import com.github.alexabak.easy_cli.ParserKind;

/**
 * Класс параметров командной строки для тестирования
 * @author Алексей Кляузер <drum@pisem.net>
 * @version 0.0.1
 * @since 0.0.1
 */
@ParserKind(syntax = "TestSyntax [OPTIONS]")
public class TestParameters extends Parameters {

	/**
	 * Конструктор
	 * @param args Аргументы командной строки
	 * @param r Пакет ресурсов для чтения описания
	 * @throws ParseException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @author Алексей Кляузер <drum@pisem.net>
	 * @version 0.0.1
	 * @since 0.0.1
	 */
	public TestParameters(String[] args, ResourceBundle r)
			throws ParseException, IllegalArgumentException,
			IllegalAccessException {
		super(args, r);
	}

	/**
	 * Булево значение true для тестов
	 * @author Алексей Кляузер <drum@pisem.net>
	 * @version 0.0.1
	 * @since 0.0.1
	 */
	@Parameter(shortName = "t", longName="true")
	public boolean trueBoolean;

	/**
	 * Булево значение false для тестов
	 * @author Алексей Кляузер <drum@pisem.net>
	 * @version 0.0.1
	 * @since 0.0.1
	 */
	@Parameter(shortName = "f")
	public boolean falseBoolean;

	/**
	 * Строковое значение "test" для тестов
	 * @author Алексей Кляузер <drum@pisem.net>
	 * @version 0.0.1
	 * @since 0.0.1
	 */
	@Parameter(shortName="s", longName="string", hasValue = true)
	public String trueString;

	/**
	 * Строковое значение null для тестов
	 * @author Алексей Кляузер <drum@pisem.net>
	 * @version 0.0.1
	 * @since 0.0.1
	 */
	@Parameter(shortName="n", hasValue = true)
	public String falseString;

}

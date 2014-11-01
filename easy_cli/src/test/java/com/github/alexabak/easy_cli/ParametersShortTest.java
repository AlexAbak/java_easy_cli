/**
 * @author Алексей Кляузер <drum@pisem.net>
 * @version 0.0.1
 * @since 0.0.1
 */
package com.github.alexabak.easy_cli;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Тестирование короткой версии параметров командной строки
 * @author Алексей Кляузер <drum@pisem.net>
 * @version 0.0.1
 * @since 0.0.1
 */
public class ParametersShortTest extends TestCase {

	/**
	 * Параметры командной строки
	 * @author Алексей Кляузер <drum@pisem.net>
	 * @version 0.0.1
	 * @since 0.0.1
	 */
	private TestParameters parameters;

	/**
	 * Инициализация тестов
	 * @author Алексей Кляузер <drum@pisem.net>
	 * @version 0.0.1
	 * @since 0.0.1
	 */
	@Override
	protected void setUp() throws Exception {
		String[] args = {"-t", "-s", "test"};
		this.parameters = new TestParameters(args, null);
		super.setUp();
	}

	/**
	 * Конструктор
	 * @param testName имя теста
	 * @author Алексей Кляузер <drum@pisem.net>
	 * @version 0.0.1
	 * @since 0.0.1
	 */
	public ParametersShortTest( String testName ) {
		super( testName );
	}

	/**
	 * @return Объект тестирования
	 * @author Алексей Кляузер <drum@pisem.net>
	 * @version 0.0.1
	 * @since 0.0.1
	 */
	public static Test suite() {
		return new TestSuite( ParametersShortTest.class );
	}

	/**
	 * Проверка булева значения true
	 * @author Алексей Кляузер <drum@pisem.net>
	 * @version 0.0.1
	 * @since 0.0.1
	 */
	public void testTrueBoolean () {
		assertEquals(true, this.parameters.trueBoolean);
	}

	/**
	 * Проверка булева значения false
	 * @author Алексей Кляузер <drum@pisem.net>
	 * @version 0.0.1
	 * @since 0.0.1
	 */
	public void testFalseBoolean () {
		assertEquals(false, this.parameters.falseBoolean);
	}

	/**
	 * Проверка строкового значения "test"
	 * @author Алексей Кляузер <drum@pisem.net>
	 * @version 0.0.1
	 * @since 0.0.1
	 */
	public void testTrueString () {
		assertEquals("test", this.parameters.trueString);
	}

	/**
	 * Проверка строкового значения null
	 * @author Алексей Кляузер <drum@pisem.net>
	 * @version 0.0.1
	 * @since 0.0.1
	 */
	public void testFalseString () {
		assertNull(this.parameters.falseString);
	}

}

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

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Тестирование длинной версии параметров командной строки
 * @author Алексей Кляузер <drum@pisem.net>
 * @version 0.0.1
 * @since 0.0.1
 */
public class ParametersLongTest extends TestCase {

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
		String[] args = {"--true", "-string", "test"};
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
	public ParametersLongTest( String testName ) {
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

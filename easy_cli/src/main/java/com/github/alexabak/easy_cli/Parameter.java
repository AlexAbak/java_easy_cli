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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация параметра командной строки
 * @since 0.0.1
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Parameter {

	/**
	 * Короткое имя параметра
	 * @return Короткое имя параметра
	 * @since 0.0.1
	 */
	public String shortName ();

	/**
	 * Длинное имя параметра
	 * @return Длинное имя параметра
	 * @since 0.0.1
	 */
	public String longName () default "";

	/**
	 * Параметр имеет значение
	 * @return Параметр имеет значение
	 * @since 0.0.1
	 */
	public boolean hasValue () default false;

	/**
	 * Идентификатор описания параметра
	 * @return Идентификатор описания параметра
	 * @since 0.0.1
	 */
	public String description () default "";

}

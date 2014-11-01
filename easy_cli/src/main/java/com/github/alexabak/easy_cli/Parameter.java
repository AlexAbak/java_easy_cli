/**
 * @author Алексей Кляузер <drum@pisem.net>
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

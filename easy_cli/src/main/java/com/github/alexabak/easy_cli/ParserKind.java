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
 * Аннотация вида анализатора командной строки
 * @since 0.0.1
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParserKind {

	/**
	 * Перечисление доступных видов анализаторов
	 * @since 0.0.1
	 */
	public enum Kind {

		POSIX, GNU

	}

	/**
	 * Вид анализатора
	 * @return Вид анализатора
	 * @since 0.0.1
	 */
	public Kind kind () default Kind.POSIX;

	/**
	 * Синтаксис командной строки
	 * @return Синтаксис командной строки
	 * @since 0.0.1
	 */
	public String syntax ();

}

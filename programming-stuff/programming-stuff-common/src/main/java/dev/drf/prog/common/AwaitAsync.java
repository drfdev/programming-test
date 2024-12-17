package dev.drf.prog.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Ожидает асинхронно
 * Этой аннотацией метится код, который выполняет асинхронное ожидание
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({
        ElementType.TYPE,
        ElementType.METHOD,
        ElementType.CONSTRUCTOR,
        ElementType.FIELD
})
public @interface AwaitAsync {
}

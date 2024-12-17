package dev.drf.prog.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Ожидание с таймаутом
 * Этой аннотацией метится код, который ожидает выполнения операции с таймаутом
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({
        ElementType.TYPE,
        ElementType.METHOD,
        ElementType.CONSTRUCTOR,
        ElementType.FIELD
})
public @interface AwaitWithTimeout {
}

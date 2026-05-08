package dev.drf.prog.fun.str.testing;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

import static dev.drf.prog.fun.str.testing.StringTesting.ITERATION_COUNT;

public class StringFormatTest {
    private static final String USERNAME = "user_name";
    private static final int IP = 123456;

    @Test
    void testStringFormat() {
        // prepare
        var timer = SimpleTimer.newTimer();

        // action
        for (int i = 0; i < ITERATION_COUNT; i++) {
            String s = String.format("User %s logged in from %s", USERNAME, IP);
        }

        // assert
        long time = timer.stop();
        System.out.println("Execution time: " + time + " nanos");
        System.out.println("Execution time: " + TimeUnit.NANOSECONDS.toMillis(time) + " millis");
    }

    @Test
    void testStringFormatted() {
        // prepare
        var timer = SimpleTimer.newTimer();

        // action
        for (int i = 0; i < ITERATION_COUNT; i++) {
            String json = """
                    {
                        "user": "%s",
                        "ip": "%s"
                    }
                    """.formatted(USERNAME, IP);
        }

        // assert
        long time = timer.stop();
        System.out.println("Execution time: " + time + " nanos");
        System.out.println("Execution time: " + TimeUnit.NANOSECONDS.toMillis(time) + " millis");
    }

    @Test
    void testStringMessageFormat() {
        // prepare
        final var messageFormat = new MessageFormat("User {0} logged in from {1}");
        final var objects = new Object[]{USERNAME, IP};
        var timer = SimpleTimer.newTimer();

        // action
        for (int i = 0; i < ITERATION_COUNT; i++) {
            String json = messageFormat.format(objects);
        }

        // assert
        long time = timer.stop();
        System.out.println("Execution time: " + time + " nanos");
        System.out.println("Execution time: " + TimeUnit.NANOSECONDS.toMillis(time) + " millis");
    }

    /*
    @Test
    void testStringTemplate() {
        // prepare
        var timer = SimpleTimer.newTimer();

        // action
        for (int i = 0; i < ITERATION_COUNT; i++) {
            String json = STR."User \{USERNAME} logged in from \{IP}";
        }

        // assert
        long time = timer.stop();
        System.out.println("Execution time: " + time + " nanos");
        System.out.println("Execution time: " + TimeUnit.NANOSECONDS.toMillis(time) + " millis");
    }
     */
}

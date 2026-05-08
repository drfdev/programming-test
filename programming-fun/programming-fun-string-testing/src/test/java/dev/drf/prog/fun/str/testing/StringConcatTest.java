package dev.drf.prog.fun.str.testing;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static dev.drf.prog.fun.str.testing.StringTesting.ITERATION_COUNT;

public class StringConcatTest {
    private static final String STR_A = "String_A";
    private static final String STR_B = "String_B";
    private static final String STR_C = "String_C";

    private String testConcat() {
        String s = STR_A + STR_B + STR_C;
        return s;
    }

    @Test
    void testConcatWithPlusLoop() {
        // prepare
        var timer = SimpleTimer.newTimer();

        // action
        for (int i = 0; i < ITERATION_COUNT; i++) {
            String s = STR_A + STR_B + STR_C;
        }

        // assert
        long time = timer.stop();
        System.out.println("Execution time: " + time + " nanos");
        System.out.println("Execution time: " + TimeUnit.NANOSECONDS.toMillis(time) + " millis");
    }

    @Test
    void testConcatWithStringBuilderLoop() {
        // prepare
        var timer = SimpleTimer.newTimer();

        // action
        for (int i = 0; i < ITERATION_COUNT; i++) {
            String s = new StringBuffer()
                    .append(STR_A)
                    .append(STR_B)
                    .append(STR_C)
                    .toString();
        }

        // assert
        long time = timer.stop();
        System.out.println("Execution time: " + time + " nanos");
        System.out.println("Execution time: " + TimeUnit.NANOSECONDS.toMillis(time) + " millis");
    }

    @Test
    void testConcatWithPlusAndInnerFunctionLoop() {
        // prepare
        var timer = SimpleTimer.newTimer();

        // action
        for (int i = 0; i < ITERATION_COUNT; i++) {
            String res = testConcat();
        }

        // assert
        long time = timer.stop();
        System.out.println("Execution time: " + time + " nanos");
        System.out.println("Execution time: " + TimeUnit.NANOSECONDS.toMillis(time) + " millis");
    }

    @Test
    void testLengthWithPlusLoop() {
        // prepare
        var timer = SimpleTimer.newTimer();

        // action
        for (int i = 0; i < ITERATION_COUNT; i++) {
            int s = (STR_A + STR_B + STR_C).length();
        }

        // assert
        long time = timer.stop();
        System.out.println("Execution time: " + time + " nanos");
        System.out.println("Execution time: " + TimeUnit.NANOSECONDS.toMillis(time) + " millis");
    }

    @Test
    void testLengthWithStringBuilderLoop() {
        // prepare
        var timer = SimpleTimer.newTimer();

        // action
        for (int i = 0; i < ITERATION_COUNT; i++) {
            int s = new StringBuffer()
                    .append(STR_A)
                    .append(STR_B)
                    .append(STR_C)
                    .length();
        }

        // assert
        long time = timer.stop();
        System.out.println("Execution time: " + time + " nanos");
        System.out.println("Execution time: " + TimeUnit.NANOSECONDS.toMillis(time) + " millis");
    }
}

package dev.drf.prog.fun.str.testing;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static dev.drf.prog.fun.str.testing.StringTesting.ITERATION_COUNT;

public class StringLoopTest {

    @Test
    void testSimpleLoop() {
        // prepare
        var timer = SimpleTimer.newTimer();

        // action
        String result = "";
        for (int i = 0; i < ITERATION_COUNT; i++) {
            result += String.valueOf(i);
        }

        // assert
        long time = timer.stop();
        System.out.println("Execution time: " + time + " nanos");
        System.out.println("Execution time: " + TimeUnit.NANOSECONDS.toMillis(time) + " millis");
    }

    @Test
    void testStringBuilderLoop() {
        // prepare
        var timer = SimpleTimer.newTimer();

        // action
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < ITERATION_COUNT; i++) {
            result.append(i);
        }

        // assert
        long time = timer.stop();
        System.out.println("Execution time: " + time + " nanos");
        System.out.println("Execution time: " + TimeUnit.NANOSECONDS.toMillis(time) + " millis");
    }

    @Test
    void testStringListReduce() {
        // prepare
        var list = IntStream.range(0, ITERATION_COUNT)
                .boxed()
                .map(Objects::toString)
                .toList();
        var timer = SimpleTimer.newTimer();

        // action
        String result = list.stream()
                .reduce("", (acc, item) -> acc + item);

        // assert
        long time = timer.stop();
        System.out.println("Execution time: " + time + " nanos");
        System.out.println("Execution time: " + TimeUnit.NANOSECONDS.toMillis(time) + " millis");
    }

    @Test
    void testStringListJoining() {
        // prepare
        var list = IntStream.range(0, ITERATION_COUNT)
                .boxed()
                .map(Objects::toString)
                .toList();
        var timer = SimpleTimer.newTimer();

        // action
        String result = list.stream()
                .collect(Collectors.joining());

        // assert
        long time = timer.stop();
        System.out.println("Execution time: " + time + " nanos");
        System.out.println("Execution time: " + TimeUnit.NANOSECONDS.toMillis(time) + " millis");
    }

    @Test
    void testStringListJoin() {
        // prepare
        var list = IntStream.range(0, ITERATION_COUNT)
                .boxed()
                .map(Objects::toString)
                .toList();
        var timer = SimpleTimer.newTimer();

        // action
        String result = String.join("", list);

        // assert
        long time = timer.stop();
        System.out.println("Execution time: " + time + " nanos");
        System.out.println("Execution time: " + TimeUnit.NANOSECONDS.toMillis(time) + " millis");
    }
}

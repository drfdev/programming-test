package dev.drf.prog.structures.stack;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class DrfStackTest {
    @Test
    void checkIsEmpty_whenEmptyStack() {
        // prepare
        var stack = new DrfStack<String>();

        // action
        boolean empty = stack.isEmpty();

        // assert
        assertTrue(empty);
    }

    @Test
    void checkIsNotEmpty_whenEmptyStack() {
        // prepare
        var stack = new DrfStack<String>();

        // action
        boolean empty = stack.isNotEmpty();

        // assert
        assertFalse(empty);
    }

    @Test
    void checkIsEmpty_whenStackWithSingleElement() {
        // prepare
        var stack = new DrfStack<String>();
        stack.push("value");

        // action
        boolean empty = stack.isEmpty();

        // assert
        assertFalse(empty);
    }

    @Test
    void checkIsEmpty_whenStackWithSeveralElements() {
        // prepare
        var stack = new DrfStack<String>();
        stack.push("value_1");
        stack.push("value_2");
        stack.push("value_3");

        // action
        boolean empty = stack.isEmpty();

        // assert
        assertFalse(empty);
    }

    @Test
    void checkIsEmpty_whenStackPushAndPopSingleElement() {
        // prepare
        var stack = new DrfStack<String>();
        stack.push("value");
        stack.pop();

        // action
        boolean empty = stack.isEmpty();

        // assert
        assertTrue(empty);
    }

    @Test
    void checkPopElement_whenStackPushSingleElement() {
        // prepare
        var stack = new DrfStack<String>();
        stack.push("value");

        // action
        var value = stack.pop();

        // assert
        assertEquals("value", value);
    }

    @Test
    void checkPopElement_whenStackPushSeveralElements() {
        // prepare
        var stack = new DrfStack<String>();
        stack.push("value_1");
        stack.push("value_2");
        stack.push("value_3");

        // action
        var value = stack.pop();

        // assert
        assertEquals("value_3", value);
    }

    @Test
    void checkPopSeveralElements_whenStackPushSeveralElements() {
        // prepare
        var stack = new DrfStack<String>();
        stack.push("value_1");
        stack.push("value_2");
        stack.push("value_3");

        // action
        var value1 = stack.pop();
        var value2 = stack.pop();
        var value3 = stack.pop();

        // assert
        assertEquals("value_3", value1);
        assertEquals("value_2", value2);
        assertEquals("value_1", value3);
    }

    @Test
    void checkPop_whenEmptyStack() {
        // prepare
        var stack = new DrfStack<String>();

        // action - assert
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    void checkPeek_whenEmptyStack() {
        // prepare
        var stack = new DrfStack<String>();

        // action - assert
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    void checkIsEmpty_whenStackPushAndPeekSingleElement() {
        // prepare
        var stack = new DrfStack<String>();
        stack.push("value");
        stack.peek();

        // action
        boolean empty = stack.isEmpty();

        // assert
        assertFalse(empty);
    }

    @Test
    void checkPeekElement_whenStackPushSingleElement() {
        // prepare
        var stack = new DrfStack<String>();
        stack.push("value");

        // action
        var value = stack.peek();

        // assert
        assertEquals("value", value);
    }

    @Test
    void checkPeekElement_whenStackPushSeveralElements() {
        // prepare
        var stack = new DrfStack<String>();
        stack.push("value_1");
        stack.push("value_2");
        stack.push("value_3");

        // action
        var value = stack.peek();

        // assert
        assertEquals("value_3", value);
    }

    @Test
    void checkPeekSeveralElements_whenStackPushSeveralElements() {
        // prepare
        var stack = new DrfStack<String>();
        stack.push("value_1");
        stack.push("value_2");
        stack.push("value_3");

        // action
        var value1 = stack.peek();
        var value2 = stack.peek();
        var value3 = stack.peek();

        // assert
        assertEquals("value_3", value1);
        assertEquals("value_3", value2);
        assertEquals("value_3", value3);
    }

    @Test
    void checkPeek_whenStackPushAndPopSeveralElements() {
        // prepare
        var stack = new DrfStack<String>();
        stack.push("value_1");
        stack.push("value_2");
        stack.push("value_3");

        stack.pop();
        stack.pop();

        // action
        var value1 = stack.peek();
        var value2 = stack.peek();
        var value3 = stack.peek();

        // assert
        assertEquals("value_1", value1);
        assertEquals("value_1", value2);
        assertEquals("value_1", value3);
    }
}

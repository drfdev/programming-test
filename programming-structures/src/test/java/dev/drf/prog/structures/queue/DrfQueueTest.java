package dev.drf.prog.structures.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DrfQueueTest {
    @Test
    void checkIsEmpty_whenEmptyQueue() {
        // prepare
        var queue = new DrfQueue<String>();

        // action
        boolean empty = queue.isEmpty();

        // assert
        assertTrue(empty);
    }

    @Test
    void checkIsNotEmpty_whenEmptyQueue() {
        // prepare
        var queue = new DrfQueue<String>();

        // action
        boolean empty = queue.isNotEmpty();

        // assert
        assertFalse(empty);
    }

    @Test
    void checkIsEmpty_whenSingleElementAdded() {
        // prepare
        var queue = new DrfQueue<String>();
        queue.add("value");

        // action
        boolean empty = queue.isEmpty();

        // assert
        assertFalse(empty);
    }

    @Test
    void checkIsEmpty_whenSeveralElementsAdded() {
        // prepare
        var queue = new DrfQueue<String>();
        queue.add("value_1");
        queue.add("value_2");
        queue.add("value_3");

        // action
        boolean empty = queue.isEmpty();

        // assert
        assertFalse(empty);
    }

    @Test
    void checkIsEmpty_whenSingleElementAddedAndPopped() {
        // prepare
        var queue = new DrfQueue<String>();
        queue.add("value");
        queue.pop();

        // action
        boolean empty = queue.isEmpty();

        // assert
        assertTrue(empty);
    }

    @Test
    void checkIsEmpty_whenSingleElementAddedAndPoppedAndNewValueAddedAgain() {
        // prepare
        var queue = new DrfQueue<String>();
        queue.add("value");
        queue.pop();
        queue.add("new_value");

        // action
        boolean empty = queue.isEmpty();

        // assert
        assertFalse(empty);
    }

    @Test
    void checkIsEmpty_whenSingleElementAddedAndPeeked() {
        // prepare
        var queue = new DrfQueue<String>();
        queue.add("value");
        queue.peek();

        // action
        boolean empty = queue.isEmpty();

        // assert
        assertFalse(empty);
    }

    @Test
    void checkPop_whenEmptyQueue() {
        // prepare
        var queue = new DrfQueue<String>();

        // action - action
        assertThrows(EmptyQueueException.class, queue::pop);
    }

    @Test
    void checkPop_whenSingleElementAdded() {
        // prepare
        var queue = new DrfQueue<String>();
        queue.add("value");

        // action
        var value = queue.pop();

        // assert
        assertEquals("value", value);
    }

    @Test
    void checkPop_whenSeveralElementsAdded() {
        // prepare
        var queue = new DrfQueue<String>();
        queue.add("value_1");
        queue.add("value_2");
        queue.add("value_3");

        // action
        var value = queue.pop();

        // assert
        assertEquals("value_1", value);
    }

    @Test
    void checkPopInCorrectOrder_whenSeveralElementsAdded() {
        // prepare
        var queue = new DrfQueue<String>();
        queue.add("value_1");
        queue.add("value_2");
        queue.add("value_3");

        // action
        var value1 = queue.pop();
        var value2 = queue.pop();
        var value3 = queue.pop();

        // assert
        assertEquals("value_1", value1);
        assertEquals("value_2", value2);
        assertEquals("value_3", value3);
    }

    @Test
    void checkPeek_whenEmptyQueue() {
        // prepare
        var queue = new DrfQueue<String>();

        // action - action
        assertThrows(EmptyQueueException.class, queue::peek);
    }

    @Test
    void checkPeek_whenSingleElementAdded() {
        // prepare
        var queue = new DrfQueue<String>();
        queue.add("value");

        // action
        var value = queue.peek();

        // assert
        assertEquals("value", value);
    }

    @Test
    void checkPeek_whenSeveralElementsAdded() {
        // prepare
        var queue = new DrfQueue<String>();
        queue.add("value_1");
        queue.add("value_2");
        queue.add("value_3");

        // action
        var value = queue.peek();

        // assert
        assertEquals("value_1", value);
    }

    @Test
    void checkPeekInCorrectOrder_whenSeveralElementsAdded() {
        // prepare
        var queue = new DrfQueue<String>();
        queue.add("value_1");
        queue.add("value_2");
        queue.add("value_3");

        // action
        var value1 = queue.peek();
        var value2 = queue.peek();
        var value3 = queue.peek();

        // assert
        assertEquals("value_1", value1);
        assertEquals("value_1", value2);
        assertEquals("value_1", value3);
    }
}

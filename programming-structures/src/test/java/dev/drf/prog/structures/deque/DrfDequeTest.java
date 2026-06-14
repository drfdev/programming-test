package dev.drf.prog.structures.deque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DrfDequeTest {
    @Test
    void checkIsEmpty_whenDequeEmpty() {
        // prepare
        var dq = new DrfDeque<String>();

        // action
        boolean empty = dq.isEmpty();

        // assert
        assertTrue(empty);
    }

    @Test
    void checkIsNotEmpty_whenDequeEmpty() {
        // prepare
        var dq = new DrfDeque<String>();

        // action
        boolean empty = dq.isNotEmpty();

        // assert
        assertFalse(empty);
    }

    @Test
    void checkIsEmpty_whenSingleElementAddedFirst() {
        // prepare
        var dq = new DrfDeque<String>();
        dq.addFirst("first_value");

        // action
        boolean empty = dq.isEmpty();

        // assert
        assertFalse(empty);
    }

    @Test
    void checkIsEmpty_whenSingleElementAddedLast() {
        // prepare
        var dq = new DrfDeque<String>();
        dq.addLast("last_value");

        // action
        boolean empty = dq.isEmpty();

        // assert
        assertFalse(empty);
    }

    @Test
    void checkIsEmpty_whenSingleElementAddedFirstAndPopFirst() {
        // prepare
        var dq = new DrfDeque<String>();
        dq.addFirst("first_value");
        dq.popFirst();

        // action
        boolean empty = dq.isEmpty();

        // assert
        assertTrue(empty);
    }

    @Test
    void checkIsEmpty_whenSingleElementAddedLastAndPopLast() {
        // prepare
        var dq = new DrfDeque<String>();
        dq.addLast("last_value");
        dq.popLast();

        // action
        boolean empty = dq.isEmpty();

        // assert
        assertTrue(empty);
    }

    @Test
    void checkIsEmpty_whenSingleElementAddedFirstAndPopLast() {
        // prepare
        var dq = new DrfDeque<String>();
        dq.addFirst("first_value");
        dq.popLast();

        // action
        boolean empty = dq.isEmpty();

        // assert
        assertTrue(empty);
    }

    @Test
    void checkIsEmpty_whenSingleElementAddedLastAndPopFirst() {
        // prepare
        var dq = new DrfDeque<String>();
        dq.addLast("last_value");
        dq.popFirst();

        // action
        boolean empty = dq.isEmpty();

        // assert
        assertTrue(empty);
    }

    @Test
    void checkPopFirst_whenSingleElementAddedFirst() {
        // prepare
        var dq = new DrfDeque<String>();
        dq.addFirst("first_value");

        // action
        var value = dq.popFirst();

        // assert
        assertEquals("first_value", value);
    }

    @Test
    void checkPopFirst_whenSeveralElementsAddedFirst() {
        // prepare
        var dq = new DrfDeque<String>();
        dq.addFirst("first_value_1");
        dq.addFirst("first_value_2");
        dq.addFirst("first_value_3");

        // action
        var value = dq.popFirst();

        // assert
        assertEquals("first_value_3", value);
    }

    @Test
    void checkPopLast_whenSingleElementAddedLast() {
        // prepare
        var dq = new DrfDeque<String>();
        dq.addLast("last_value");

        // action
        var value = dq.popLast();

        // assert
        assertEquals("last_value", value);
    }

    @Test
    void checkPopLast_whenSeveralElementsAddedLast() {
        // prepare
        var dq = new DrfDeque<String>();
        dq.addLast("last_value_1");
        dq.addLast("last_value_2");
        dq.addLast("last_value_3");

        // action
        var value = dq.popLast();

        // assert
        assertEquals("last_value_3", value);
    }

    @Test
    void checkPopFirstAndPopLast_whenSeveralElementsAddedFirst() {
        // prepare
        var dq = new DrfDeque<String>();
        dq.addFirst("first_value_1");
        dq.addFirst("first_value_2");
        dq.addFirst("first_value_3");

        // action
        var valueFirst = dq.popFirst();
        var valueLast = dq.popLast();

        // assert
        assertEquals("first_value_3", valueFirst);
        assertEquals("first_value_1", valueLast);
    }

    @Test
    void checkPopFirstAndPopLast_whenSeveralElementsAddedLast() {
        // prepare
        var dq = new DrfDeque<String>();
        dq.addLast("last_value_1");
        dq.addLast("last_value_2");
        dq.addLast("last_value_3");

        // action
        var valueFirst = dq.popFirst();
        var valueLast = dq.popLast();

        // assert
        assertEquals("last_value_1", valueFirst);
        assertEquals("last_value_3", valueLast);
    }

    @Test
    void checkIsEmpty_whenSeveralElementsAddedFirstAndPoppedLast() {
        // prepare
        var dq = new DrfDeque<String>();
        dq.addFirst("first_value_1");
        dq.addFirst("first_value_2");
        dq.addFirst("first_value_3");

        dq.popLast();
        dq.popLast();
        dq.popLast();

        // action
        boolean empty = dq.isEmpty();

        // assert
        assertTrue(empty);
    }

    @Test
    void checkIsEmpty_whenSeveralElementsAddedLastAndPoppedFirst() {
        // prepare
        var dq = new DrfDeque<String>();
        dq.addLast("last_value_1");
        dq.addLast("last_value_2");
        dq.addLast("last_value_3");

        dq.popFirst();
        dq.popFirst();
        dq.popFirst();

        // action
        boolean empty = dq.isEmpty();

        // assert
        assertTrue(empty);
    }

    @Test
    void checkPopFirst_whenDequeEmpty() {
        // prepare
        var dq = new DrfDeque<String>();

        // action - assert
        assertThrows(EmptyDequeException.class, dq::popFirst);
    }

    @Test
    void checkPopLast_whenDequeEmpty() {
        // prepare
        var dq = new DrfDeque<String>();

        // action - assert
        assertThrows(EmptyDequeException.class, dq::popLast);
    }

    @Test
    void checkPeekFirst_whenDequeEmpty() {
        // prepare
        var dq = new DrfDeque<String>();

        // action - assert
        assertThrows(EmptyDequeException.class, dq::peekFirst);
    }

    @Test
    void checkPeekLast_whenDequeEmpty() {
        // prepare
        var dq = new DrfDeque<String>();

        // action - assert
        assertThrows(EmptyDequeException.class, dq::peekLast);
    }

    @Test
    void checkPeekFirst_whenDequeHasSingleElement() {
        // prepare
        var dq = new DrfDeque<String>();
        dq.addFirst("first_value");

        // action
        var value = dq.peekFirst();

        // assert
        assertEquals("first_value", value);
        assertFalse(dq.isEmpty());
    }

    @Test
    void checkPeekLast_whenDequeHasSingleElement() {
        // prepare
        var dq = new DrfDeque<String>();
        dq.addFirst("first_value");

        // action
        var value = dq.peekFirst();

        // assert
        assertEquals("first_value", value);
        assertFalse(dq.isEmpty());
    }

    @Test
    void checkPeekFirst_whenDequeHasSeveralElements() {
        // prepare
        var dq = new DrfDeque<String>();
        dq.addFirst("first_value_1");
        dq.addFirst("first_value_2");
        dq.addFirst("first_value_3");

        // action
        var value = dq.peekFirst();

        // assert
        assertEquals("first_value_3", value);
    }

    @Test
    void checkPeekLast_whenDequeHasSeveralElements() {
        // prepare
        var dq = new DrfDeque<String>();
        dq.addFirst("first_value_1");
        dq.addFirst("first_value_2");
        dq.addFirst("first_value_3");

        // action
        var value = dq.peekLast();

        // assert
        assertEquals("first_value_1", value);
    }

    @Test
    void checkCorrectness_whenElementsAddedInDifferentOrder() {
        // prepare
        var dq = new DrfDeque<String>();
        dq.addFirst("first_value_1");
        dq.addFirst("first_value_2");
        dq.addLast("last_value_1");
        dq.addLast("last_value_2");
        dq.addFirst("new_first");
        dq.addLast("new_last");

        // action
        var value1 = dq.popFirst();
        var value2 = dq.popFirst();
        var value3 = dq.popFirst();
        var value4 = dq.popFirst();
        var value5 = dq.popFirst();
        var value6 = dq.popFirst();

        // assert
        assertEquals("new_first", value1);
        assertEquals("first_value_2", value2);
        assertEquals("first_value_1", value3);
        assertEquals("last_value_1", value4);
        assertEquals("last_value_2", value5);
        assertEquals("new_last", value6);
    }
}

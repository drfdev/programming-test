package dev.drf.prog.structures.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DrfLinkedListTest {
    @Test
    void checkLength_whenEmptyList() {
        // prepare
        var list = new DrfLinkedList<String>();

        // action
        int length = list.len();

        // assert
        assertEquals(0, length);
    }

    @Test
    void checkIsEmpty_whenEmptyList() {
        // prepare
        var list = new DrfLinkedList<String>();

        // action
        boolean empty = list.isEmpty();

        // assert
        assertTrue(empty);
    }

    @Test
    void checkIsNotEmpty_whenEmptyList() {
        // prepare
        var list = new DrfLinkedList<String>();

        // action
        boolean empty = list.isNotEmpty();

        // assert
        assertFalse(empty);
    }

    @Test
    void checkLength_whenSingleElementAddedToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value");

        // action
        int length = list.len();

        // assert
        assertEquals(1, length);
    }

    @Test
    void checkIsEmpty_whenSingleElementAddedToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value");

        // action
        boolean empty = list.isEmpty();

        // assert
        assertFalse(empty);
    }

    @Test
    void checkIsNotEmpty_whenSingleElementAddedToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value");

        // action
        boolean empty = list.isNotEmpty();

        // assert
        assertTrue(empty);
    }

    @Test
    void checkLength_whenSeveralElementsAddedToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value_1");
        list.add("value_2");
        list.add("value_3");

        // action
        int length = list.len();

        // assert
        assertEquals(3, length);
    }

    @Test
    void checkIsEmpty_whenSeveralElementsAddedToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value_1");
        list.add("value_2");
        list.add("value_3");

        // action
        boolean empty = list.isEmpty();

        // assert
        assertFalse(empty);
    }

    @Test
    void checkGet_whenSingleElementAddedToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value");

        // action
        var value = list.get(0);

        // assert
        assertEquals("value", value);
    }

    @Test
    void checkGet_whenSeveralElementsAddedToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value_1");
        list.add("value_2");
        list.add("value_3");

        // action
        var value1 = list.get(0);
        var value2 = list.get(1);
        var value3 = list.get(2);

        // assert
        assertEquals("value_1", value1);
        assertEquals("value_2", value2);
        assertEquals("value_3", value3);
    }

    @Test
    void checkGetFirst_whenSingleElementAddedToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value");

        // action
        var value = list.getFirst();

        // assert
        assertEquals("value", value);
    }

    @Test
    void checkGetFirst_whenSeveralElementsAddedToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value_1");
        list.add("value_2");
        list.add("value_3");

        // action
        var value = list.getFirst();

        // assert
        assertEquals("value_1", value);
    }

    @Test
    void checkGetLast_whenSingleElementAddedToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value");

        // action
        var value = list.getLast();

        // assert
        assertEquals("value", value);
    }

    @Test
    void checkGetLast_whenSeveralElementsAddedToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value_1");
        list.add("value_2");
        list.add("value_3");

        // action
        var value = list.getLast();

        // assert
        assertEquals("value_3", value);
    }

    @Test
    void checkLength_whenSingleElementAddedAndRemovedToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value");
        list.remove(0);

        // action
        int length = list.len();

        // assert
        assertEquals(0, length);
    }

    @Test
    void checkIsEmpty_whenSingleElementAddedAndRemovedToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value");
        list.remove(0);

        // action
        boolean empty = list.isEmpty();

        // assert
        assertTrue(empty);
    }

    @Test
    void checkRemovedObject_whenSingleElementAddedAndRemovedToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value");

        // action
        var value = list.remove(0);

        // assert
        assertEquals("value", value);
    }

    @Test
    void checkLength_whenSeveralElementsAddedAndRemovedToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value_1");
        list.add("value_2");
        list.add("value_3");
        list.remove(0);

        // action
        int length = list.len();

        // assert
        assertEquals(2, length);
    }

    @Test
    void checkIsEmpty_whenSeveralElementsAddedAndRemovedToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value_1");
        list.add("value_2");
        list.add("value_3");
        list.remove(0);

        // action
        boolean empty = list.isEmpty();

        // assert
        assertFalse(empty);
    }

    @Test
    void checkRemovedObject_whenSeveralElementsAddedAndRemovedToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value_1");
        list.add("value_2");
        list.add("value_3");

        // action
        var value = list.remove(0);

        // assert
        assertEquals("value_1", value);
    }

    @Test
    void checkGet_whenSeveralElementsAddedAndRemovedToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value_1");
        list.add("value_2");
        list.add("value_3");
        list.remove(1);

        // action
        var value1 = list.get(0);
        var value2 = list.get(1);

        // assert
        assertEquals("value_1", value1);
        assertEquals("value_3", value2);
    }

    @Test
    void checkGetFirst_whenEmptyList() {
        // prepare
        var list = new DrfLinkedList<String>();

        // action - assert
        assertThrows(IndexOutOfBoundsException.class, list::getFirst);
    }

    @Test
    void checkGetLast_whenEmptyList() {
        // prepare
        var list = new DrfLinkedList<String>();

        // action - assert
        assertThrows(IndexOutOfBoundsException.class, list::getLast);
    }

    @Test
    void checkGet_whenNegativeIndex() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value_1");
        list.add("value_2");

        // action - assert
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-10));
    }

    @Test
    void checkGet_whenIndexTooBig() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value_1");
        list.add("value_2");

        // action - assert
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(999));
    }

    @Test
    void checkAddLast_whenSingleElementAddedToList() {
        // prepare
        var list = new DrfLinkedList<String>();

        // action
        list.addLast("value");

        // assert
        int length = list.len();
        assertEquals(1, length);

        var value = list.get(0);
        assertEquals("value", value);
    }

    @Test
    void checkAddLast_whenSeveralElementsAddedToList() {
        // prepare
        var list = new DrfLinkedList<String>();

        // action
        list.addLast("value_1");
        list.addLast("value_2");
        list.addLast("value_3");

        // assert
        int length = list.len();
        assertEquals(3, length);

        var value1 = list.get(0);
        var value2 = list.get(1);
        var value3 = list.get(2);
        assertEquals("value_1", value1);
        assertEquals("value_2", value2);
        assertEquals("value_3", value3);
    }

    @Test
    void checkAddFirst_whenSingleElementAddedToList() {
        // prepare
        var list = new DrfLinkedList<String>();

        // action
        list.addFirst("value");

        // assert
        int length = list.len();
        assertEquals(1, length);

        var value = list.get(0);
        assertEquals("value", value);
    }

    @Test
    void checkAddFirst_whenSeveralElementsAddedToList() {
        // prepare
        var list = new DrfLinkedList<String>();

        // action
        list.addFirst("value_1");
        list.addFirst("value_2");
        list.addFirst("value_3");

        // assert
        int length = list.len();
        assertEquals(3, length);

        var value1 = list.get(0);
        var value2 = list.get(1);
        var value3 = list.get(2);
        assertEquals("value_3", value1);
        assertEquals("value_2", value2);
        assertEquals("value_1", value3);
    }

    @Test
    void checkGet_whenUsedSearchByIndexWithLowerDirection() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value_1");
        list.add("value_2");
        list.add("value_3");
        list.add("value_4");
        list.add("value_5");

        // action
        var value = list.get(1);

        // assert
        assertEquals("value_2", value);
    }

    @Test
    void checkGet_whenUsedSearchByIndexWithHigherDirection() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value_1");
        list.add("value_2");
        list.add("value_3");
        list.add("value_4");
        list.add("value_5");

        // action
        var value = list.get(3);

        // assert
        assertEquals("value_4", value);
    }

    @Test
    void checkRemoveFirstElement_whenSeveralElementsToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value_1");
        list.add("value_2");
        list.add("value_3");
        list.add("value_4");
        list.add("value_5");

        // action
        var removed = list.get(0);

        // assert
        assertEquals("value_1", removed);
    }

    @Test
    void checkRemoveLastElement_whenSeveralElementsToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value_1");
        list.add("value_2");
        list.add("value_3");
        list.add("value_4");
        list.add("value_5");

        // action
        var removed = list.get(4);

        // assert
        assertEquals("value_5", removed);
    }

    @Test
    void checkRemoveMiddleElement_whenSeveralElementsToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value_1");
        list.add("value_2");
        list.add("value_3");
        list.add("value_4");
        list.add("value_5");

        // action
        var removed = list.get(2);

        // assert
        assertEquals("value_3", removed);
    }

    @Test
    void checkSet_whenSeveralElementsToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value_1");
        list.add("value_2");
        list.add("value_3");

        // action
        list.set(0, "changed");

        // assert
        var value1 = list.get(0);
        var value2 = list.get(1);
        var value3 = list.get(2);
        assertEquals("changed", value1);
        assertEquals("value_2", value2);
        assertEquals("value_3", value3);
    }

    @Test
    void checkSetForSeveralElements_whenSeveralElementsToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value_1");
        list.add("value_2");
        list.add("value_3");

        // action
        list.set(0, "changed_1");
        list.set(1, "changed_2");
        list.set(2, "changed_3");

        // assert
        var value1 = list.get(0);
        var value2 = list.get(1);
        var value3 = list.get(2);
        assertEquals("changed_1", value1);
        assertEquals("changed_2", value2);
        assertEquals("changed_3", value3);
    }

    @Test
    void checkSetMiddleElement_whenSeveralElementsToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value_1");
        list.add("value_2");
        list.add("value_3");

        // action
        list.set(1, "changed");

        // assert
        var value1 = list.get(0);
        var value2 = list.get(1);
        var value3 = list.get(2);
        assertEquals("value_1", value1);
        assertEquals("changed", value2);
        assertEquals("value_3", value3);
    }

    @Test
    void checkSetFirst_whenSeveralElementsToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value_1");
        list.add("value_2");
        list.add("value_3");

        // action
        list.setFirst("changed");

        // assert
        var value1 = list.get(0);
        var value2 = list.get(1);
        var value3 = list.get(2);
        assertEquals("changed", value1);
        assertEquals("value_2", value2);
        assertEquals("value_3", value3);
    }

    @Test
    void checkSetLast_whenSeveralElementsToList() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value_1");
        list.add("value_2");
        list.add("value_3");

        // action
        list.setLast("changed");

        // assert
        var value1 = list.get(0);
        var value2 = list.get(1);
        var value3 = list.get(2);
        assertEquals("value_1", value1);
        assertEquals("value_2", value2);
        assertEquals("changed", value3);
    }

    @Test
    void checkIterator_whenEmptyList() {
        // prepare
        var list = new DrfLinkedList<String>();

        // action
        var iterator = list.iterator();

        // assert
        assertFalse(iterator.hasNext());
    }

    @Test
    void checkIterator_whenListWithSeveralElements() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value_1");
        list.add("value_2");
        list.add("value_3");

        // action
        var iterator = list.iterator();

        // assert
        final var buff = new StringBuilder();
        for (; iterator.hasNext(); ) {
            var value = iterator.next();
            buff.append(value);
        }

        assertEquals("value_1value_2value_3", buff.toString());
    }

    @Test
    void checkForEach_whenListWithSeveralElements() {
        // prepare
        var list = new DrfLinkedList<String>();
        list.add("value_1");
        list.add("value_2");
        list.add("value_3");

        // action
        final var buff = new StringBuilder();
        list.forEach(buff::append);
        var iterator = list.iterator();

        // assert
        assertEquals("value_1value_2value_3", buff.toString());
    }
}

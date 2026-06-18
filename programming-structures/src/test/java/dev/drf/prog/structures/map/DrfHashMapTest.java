package dev.drf.prog.structures.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DrfHashMapTest {

    private <T> T getPrivateFirstValue(Object obj, String fiendName) throws Exception {
        var field = obj.getClass().getDeclaredField(fiendName);
        field.setAccessible(true);
        return (T) field.get(obj);
    }

    @Test
    void checkIsEmpty_whenEmptyMap() {
        // prepare
        var map = new DrfHashMap<Integer, String>();

        // action
        boolean empty = map.isEmpty();

        // assert
        assertTrue(empty);
    }

    @Test
    void checkIsNotEmpty_whenEmptyMap() {
        // prepare
        var map = new DrfHashMap<Integer, String>();

        // action
        boolean empty = map.isNotEmpty();

        // assert
        assertFalse(empty);
    }

    @Test
    void checkIsEmpty_whenSinglePairPuttedInMap() {
        // prepare
        var map = new DrfHashMap<Integer, String>();
        map.put(1, "one");

        // action
        boolean empty = map.isEmpty();

        // assert
        assertFalse(empty);
    }

    @Test
    void checkIsNotEmpty_whenSinglePairPuttedInMap() {
        // prepare
        var map = new DrfHashMap<Integer, String>();
        map.put(1, "one");

        // action
        boolean empty = map.isNotEmpty();

        // assert
        assertTrue(empty);
    }

    @Test
    void checkIsEmpty_whenSinglePairPuttedAndRemovedInMap() {
        // prepare
        var map = new DrfHashMap<Integer, String>();
        map.put(1, "one");
        map.remove(1);

        // action
        boolean empty = map.isEmpty();

        // assert
        assertTrue(empty);
    }

    @Test
    void checkIsNotEmpty_whenSinglePairPuttedAndRemovedInMap() {
        // prepare
        var map = new DrfHashMap<Integer, String>();
        map.put(1, "one");
        map.remove(1);

        // action
        boolean empty = map.isNotEmpty();

        // assert
        assertFalse(empty);
    }

    @Test
    void checkSize_whenEmptyMap() {
        // prepare
        var map = new DrfHashMap<Integer, String>();

        // action
        int size = map.size();

        // assert
        assertEquals(0, size);
    }

    @Test
    void checkSize_whenSinglePairPuttedInMap() {
        // prepare
        var map = new DrfHashMap<Integer, String>();
        map.put(1, "one");

        // action
        int size = map.size();

        // assert
        assertEquals(1, size);
    }

    @Test
    void checkSize_whenSinglePairPuttedAndRemovedInMap() {
        // prepare
        var map = new DrfHashMap<Integer, String>();
        map.put(1, "one");
        map.remove(1);

        // action
        int size = map.size();

        // assert
        assertEquals(0, size);
    }

    @Test
    void checkGet_whenEmptyMap() {
        // prepare
        var map = new DrfHashMap<Integer, String>();

        // action
        var value = map.get(10);

        // assert
        assertNull(value);
    }

    @Test
    void checkGet_whenMapContainsSingleElement() {
        // prepare
        var map = new DrfHashMap<Integer, String>();
        map.put(1, "one");

        // action
        var value = map.get(1);

        // assert
        assertNotNull(value);
        assertEquals("one", value);
    }

    @Test
    void checkGetUnknownKey_whenMapContainsSingleElement() {
        // prepare
        var map = new DrfHashMap<Integer, String>();
        map.put(1, "one");

        // action
        var value = map.get(99);

        // assert
        assertNull(value);
    }

    @Test
    void checkGetRemovedKey_whenSingleElementAddedAndRemoved() {
        // prepare
        var map = new DrfHashMap<Integer, String>();
        map.put(1, "one");
        map.remove(1);

        // action
        var value = map.get(1);

        // assert
        assertNull(value);
    }

    @Test
    void checkContains_whenEmptyMap() {
        // prepare
        var map = new DrfHashMap<Integer, String>();

        // action
        boolean contains = map.contains(10);

        // assert
        assertFalse(contains);
    }

    @Test
    void checkContains_whenMapContainsSingleElement() {
        // prepare
        var map = new DrfHashMap<Integer, String>();
        map.put(1, "one");

        // action
        boolean contains = map.contains(1);

        // assert
        assertTrue(contains);
    }

    @Test
    void checkContainsUnknownKey_whenMapContainsSingleElement() {
        // prepare
        var map = new DrfHashMap<Integer, String>();
        map.put(1, "one");

        // action
        boolean contains = map.contains(99);

        // assert
        assertFalse(contains);
    }

    @Test
    void checkContainsRemovedKey_whenSingleElementAddedAndRemoved() {
        // prepare
        var map = new DrfHashMap<Integer, String>();
        map.put(1, "one");
        map.remove(1);

        // action
        boolean contains = map.contains(1);

        // assert
        assertFalse(contains);
    }

    @Test
    void checkPut_whenSingleElementAdded() {
        // prepare
        var map = new DrfHashMap<Integer, String>();

        // action
        map.put(1, "one");

        // assert
        var value = map.get(1);
        assertEquals("one", value);
    }

    @Test
    void checkPut_whenSeveralElementsAddedWithDifferentKeys() {
        // prepare
        var map = new DrfHashMap<Integer, String>(10);

        // action
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        // assert
        var value1 = map.get(1);
        var value2 = map.get(2);
        var value3 = map.get(3);
        assertEquals("one", value1);
        assertEquals("two", value2);
        assertEquals("three", value3);
    }

    @Test
    void checkPut_whenSeveralElementsAddedWithSameKeys() {
        // prepare
        var map = new DrfHashMap<Integer, String>(10);

        // action
        map.put(1, "one");
        map.put(1, "two");
        map.put(1, "three");

        // assert
        var value = map.get(1);
        assertEquals("three", value);
        int size = map.size();
        assertEquals(1, size);
    }

    @Test
    void checkPut_whenSeveralElementsAddedWithSameKeysHash() {
        // prepare
        var map = new DrfHashMap<Integer, String>(10);

        // action
        map.put(1, "one");
        map.put(11, "two");
        map.put(21, "three");

        // assert
        int size = map.size();
        assertEquals(3, size);

        var value1 = map.get(1);
        var value2 = map.get(11);
        var value3 = map.get(21);
        assertEquals("one", value1);
        assertEquals("two", value2);
        assertEquals("three", value3);
    }

    @Test
    void checkPut_whenCapacityUpdated() throws Exception {
        // prepare
        var map = new DrfHashMap<Integer, String>(3, 1);

        // action
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");

        // assert
        int size = map.size();
        assertEquals(4, size);

        var value1 = map.get(1);
        var value2 = map.get(2);
        var value3 = map.get(3);
        var value4 = map.get(4);
        assertEquals("one", value1);
        assertEquals("two", value2);
        assertEquals("three", value3);
        assertEquals("four", value4);

        // capacity: 3 -> 6
        int capacity = getPrivateFirstValue(map, "capacity");
        assertEquals(6, capacity);
    }

    @Test
    void checkRemove_whenEmptyMap() {
        // prepare
        var map = new DrfHashMap<Integer, String>();

        // action
        var removed = map.remove(7);

        // assert
        assertNull(removed);
    }

    @Test
    void checkRemove_whenMapWithSingleElement() {
        // prepare
        var map = new DrfHashMap<Integer, String>();
        map.put(7, "to_remove");

        // action
        var removed = map.remove(7);

        // assert
        assertNotNull(removed);
        assertEquals("to_remove", removed);

        int size = map.size();
        assertEquals(0, size);
    }

    @Test
    void checkRemove_whenMapWithSeveralElements() {
        // prepare
        var map = new DrfHashMap<Integer, String>();
        map.put(7, "to_remove_7");
        map.put(9, "to_remove_9");
        map.put(12, "to_remove_12");

        // action
        var removed1 = map.remove(7);
        var removed2 = map.remove(12);

        // assert
        assertEquals("to_remove_7", removed1);
        assertEquals("to_remove_12", removed2);

        int size = map.size();
        assertEquals(1, size);
    }

    @Test
    void checkRemove_whenMapWithSeveralElementsWithSameKey() {
        // prepare
        var map = new DrfHashMap<Integer, String>();
        map.put(7, "to_remove_7");
        map.put(7, "to_remove_9");
        map.put(7, "to_remove_12");

        // action
        var removed = map.remove(7);

        // assert
        assertEquals("to_remove_12", removed);

        int size = map.size();
        assertEquals(0, size);
    }

    @Test
    void checkRemove_whenMapWithSeveralElementsWithSameKeysHash() {
        // prepare
        var map = new DrfHashMap<Integer, String>(10);
        map.put(7, "to_remove_7");
        map.put(17, "to_remove_9");
        map.put(27, "to_remove_12");

        // action
        var removed1 = map.remove(7);
        var removed2 = map.remove(27);

        // assert
        assertEquals("to_remove_7", removed1);
        assertEquals("to_remove_12", removed2);

        int size = map.size();
        assertEquals(1, size);

        var value = map.get(17);
        assertEquals("to_remove_9", value);
    }

    @Test
    void checkClear_whenEmptyMap() {
        // prepare
        var map = new DrfHashMap<Integer, String>();

        // action
        map.clear();

        // assert
        assertTrue(map.isEmpty());
    }

    @Test
    void checkClear_whenMapContainsSeveralElements() {
        // prepare
        var map = new DrfHashMap<Integer, String>();
        map.put(1, "first");
        map.put(2, "second");
        map.put(3, "third");

        // action
        map.clear();

        // assert
        assertTrue(map.isEmpty());

        assertNull(map.get(1));
        assertNull(map.get(2));
        assertNull(map.get(3));
    }

    @Test
    void checkCapacityCorrectness_whenInitValueLowerThanZero() throws Exception {
        // prepare
        var map = new DrfHashMap<Integer, String>(-20);

        // assert
        int capacity = getPrivateFirstValue(map, "capacity");
        assertEquals(1, capacity);
    }

    @Test
    void checkCapacityCorrectness_whenInitValueEqualTOZero() throws Exception {
        // prepare
        var map = new DrfHashMap<Integer, String>(0);

        // assert
        int capacity = getPrivateFirstValue(map, "capacity");
        assertEquals(1, capacity);
    }

    @Test
    void checkCapacityCorrectness_whenInitValueBiggerThanMaximumValue() throws Exception {
        // prepare
        var map = new DrfHashMap<Integer, String>(1 << 30);

        // assert
        int capacity = getPrivateFirstValue(map, "capacity");
        assertEquals((1 << 20), capacity);
    }

    @Test
    void checkLoadFactorCorrectness_whenInitValueLowerThanZero() throws Exception {
        // prepare
        var map = new DrfHashMap<Integer, String>(10, -1.0f);

        // assert
        float loadFactor = getPrivateFirstValue(map, "loadFactor");
        assertEquals(0.15f, loadFactor);
    }

    @Test
    void checkLoadFactorCorrectness_whenInitValueEqualsToZero() throws Exception {
        // prepare
        var map = new DrfHashMap<Integer, String>(10, 0.0f);

        // assert
        float loadFactor = getPrivateFirstValue(map, "loadFactor");
        assertEquals(0.15f, loadFactor);
    }

    @Test
    void checkLoadFactorCorrectness_whenInitValueLowerThanMinimum() throws Exception {
        // prepare
        var map = new DrfHashMap<Integer, String>(10, 0.09f);

        // assert
        float loadFactor = getPrivateFirstValue(map, "loadFactor");
        assertEquals(0.15f, loadFactor);
    }

    @Test
    void checkLoadFactorCorrectness_whenInitValueBiggerThanMaximum() throws Exception {
        // prepare
        var map = new DrfHashMap<Integer, String>(10, 1.1f);

        // assert
        float loadFactor = getPrivateFirstValue(map, "loadFactor");
        assertEquals(1.0f, loadFactor);
    }

    @Test
    void checkCapacityCorrectness_whenInitValueIsCorrect() throws Exception {
        // prepare
        var map = new DrfHashMap<Integer, String>(197);

        // assert
        int capacity = getPrivateFirstValue(map, "capacity");
        assertEquals(197, capacity);
    }

    @Test
    void checkLoadFactorCorrectness_whenInitValueIsCorrect() throws Exception {
        // prepare
        var map = new DrfHashMap<Integer, String>(10, 0.87f);

        // assert
        float loadFactor = getPrivateFirstValue(map, "loadFactor");
        assertEquals(0.87f, loadFactor);
    }
}

package dev.drf.prog.structures.set;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DrfHashSetTest {
    private <T> T getPrivateFirstValue(Object obj, String fiendName) throws Exception {
        var field = obj.getClass().getDeclaredField(fiendName);
        field.setAccessible(true);
        return (T) field.get(obj);
    }
    
    @Test
    void checkIsEmpty_whenEmptySet() {
        // prepare
        var set = new DrfHashSet<String>();

        // action
        boolean empty = set.isEmpty();

        // assert
        assertTrue(empty);
    }

    @Test
    void checkIsNotEmpty_whenEmptySet() {
        // prepare
        var set = new DrfHashSet<String>();

        // action
        boolean empty = set.isNotEmpty();

        // assert
        assertFalse(empty);
    }

    @Test
    void checkSize_whenEmptySet() {
        // prepare
        var set = new DrfHashSet<String>();

        // action
        int size = set.size();

        // assert
        assertEquals(0, size);
    }

    @Test
    void checkIsEmpty_whenSetWithSingleElement() {
        // prepare
        var set = new DrfHashSet<String>();
        set.put("value");

        // action
        boolean empty = set.isEmpty();

        // assert
        assertFalse(empty);
    }

    @Test
    void checkIsNotEmpty_whenSetWithSingleElement() {
        // prepare
        var set = new DrfHashSet<String>();
        set.put("value");

        // action
        boolean empty = set.isNotEmpty();

        // assert
        assertTrue(empty);
    }

    @Test
    void checkSize_whenSetWithSingleElement() {
        // prepare
        var set = new DrfHashSet<String>();
        set.put("value");

        // action
        int size = set.size();

        // assert
        assertEquals(1, size);
    }

    @Test
    void checkSize_whenSetWithSeveralElements() {
        // prepare
        var set = new DrfHashSet<String>();
        set.put("value_1");
        set.put("value_2");
        set.put("value_3");

        // action
        int size = set.size();

        // assert
        assertEquals(3, size);
    }

    @Test
    void checkSize_whenSetWithSeveralSameElements() {
        // prepare
        var set = new DrfHashSet<String>();
        set.put("value_1");
        set.put("value_1");
        set.put("value_1");

        // action
        int size = set.size();

        // assert
        assertEquals(1, size);
    }

    @Test
    void checkSize_whenSetWithSeveralElementsWithSameBucketIndex() {
        // prepare
        var set = new DrfHashSet<Integer>(10);
        set.put(1);
        set.put(11);
        set.put(21);

        // action
        int size = set.size();

        // assert
        assertEquals(3, size);
    }

    @Test
    void checkContains_whenEmptySet() {
        // prepare
        var set = new DrfHashSet<String>();

        // action
        boolean contains = set.contains("value");

        // assert
        assertFalse(contains);
    }

    @Test
    void checkContains_whenSetWithSingleElement() {
        // prepare
        var set = new DrfHashSet<String>();
        set.put("value");

        // action
        boolean contains = set.contains("value");

        // assert
        assertTrue(contains);
    }

    @Test
    void checkContains_whenSetWithSeveralElements() {
        // prepare
        var set = new DrfHashSet<String>();
        set.put("value_1");
        set.put("value_2");
        set.put("value_3");

        // action
        boolean contains = set.contains("value_2");

        // assert
        assertTrue(contains);
    }

    @Test
    void checkContains_whenSetWithSeveralSameElements() {
        // prepare
        var set = new DrfHashSet<String>();
        set.put("value_1");
        set.put("value_1");
        set.put("value_1");

        // action
        boolean contains = set.contains("value_1");

        // assert
        assertTrue(contains);
    }

    @Test
    void checkContains_whenSetWithSeveralElementsWithSameBucketIndex() {
        // prepare
        var set = new DrfHashSet<Integer>(10);
        set.put(1);
        set.put(11);
        set.put(21);

        // action
        boolean contains = set.contains(21);

        // assert
        assertTrue(contains);
    }

    @Test
    void checkContainsUnknownElement_whenSetWithSeveralElements() {
        // prepare
        var set = new DrfHashSet<String>();
        set.put("value_1");
        set.put("value_2");
        set.put("value_3");

        // action
        boolean contains = set.contains("unknown");

        // assert
        assertFalse(contains);
    }

    @Test
    void checkContains_whenSetWithOverCapacity() {
        // prepare
        var set = new DrfHashSet<String>(5);
        set.put("value_1");
        set.put("value_2");
        set.put("value_3");
        set.put("value_4");
        set.put("value_5");
        set.put("value_6");

        // action
        boolean contains1 = set.contains("value_1");
        boolean contains2 = set.contains("value_2");
        boolean contains3 = set.contains("value_3");
        boolean contains4 = set.contains("value_4");
        boolean contains5 = set.contains("value_5");
        boolean contains6 = set.contains("value_6");

        // assert
        assertTrue(contains1);
        assertTrue(contains2);
        assertTrue(contains3);
        assertTrue(contains4);
        assertTrue(contains5);
        assertTrue(contains6);

        assertEquals(6, set.size());
    }

    @Test
    void checkClear_whenEmptySet() {
        // prepare
        var set = new DrfHashSet<String>();

        // action
        set.clear();

        // assert
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
    }

    @Test
    void checkClear_whenSetWithSingleElement() {
        // prepare
        var set = new DrfHashSet<String>();
        set.put("value");

        // action
        set.clear();

        // assert
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
    }

    @Test
    void checkClear_whenSetWithSeveralElements() {
        // prepare
        var set = new DrfHashSet<String>();
        set.put("value_1");
        set.put("value_2");
        set.put("value_3");

        // action
        set.clear();

        // assert
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());

        assertFalse(set.contains("value_1"));
        assertFalse(set.contains("value_2"));
        assertFalse(set.contains("value_3"));
    }

    @Test
    void checkRemove_whenEmptySet() {
        // prepare
        var set = new DrfHashSet<String>();

        // action
        boolean removed = set.remove("remove");

        // assert
        assertFalse(removed);
    }

    @Test
    void checkRemove_whenSetWithSingleElement() {
        // prepare
        var set = new DrfHashSet<String>();
        set.put("to_remove");

        // action
        boolean removed = set.remove("to_remove");

        // assert
        assertTrue(removed);
        assertEquals(0, set.size());
    }

    @Test
    void checkRemoveSingleElement_whenSetWithSeveralElements() {
        // prepare
        var set = new DrfHashSet<String>();
        set.put("to_remove_1");
        set.put("to_remove_2");
        set.put("to_remove_3");

        // action
        boolean removed = set.remove("to_remove_2");

        // assert
        assertTrue(removed);
        assertEquals(2, set.size());

        assertTrue(set.contains("to_remove_1"));
        assertTrue(set.contains("to_remove_3"));
    }

    @Test
    void checkRemoveAllElements_whenSetWithSeveralElements() {
        // prepare
        var set = new DrfHashSet<String>();
        set.put("to_remove_1");
        set.put("to_remove_2");
        set.put("to_remove_3");

        // action
        boolean removed1 = set.remove("to_remove_1");
        boolean removed2 = set.remove("to_remove_2");
        boolean removed3 = set.remove("to_remove_3");

        // assert
        assertTrue(removed1);
        assertTrue(removed2);
        assertTrue(removed3);
        assertEquals(0, set.size());

        assertFalse(set.contains("to_remove_1"));
        assertFalse(set.contains("to_remove_2"));
        assertFalse(set.contains("to_remove_3"));
    }

    @Test
    void checkRemoveAllElementsReversedOrder_whenSetWithSeveralElements() {
        // prepare
        var set = new DrfHashSet<String>();
        set.put("to_remove_1");
        set.put("to_remove_2");
        set.put("to_remove_3");

        // action
        boolean removed3 = set.remove("to_remove_3");
        boolean removed2 = set.remove("to_remove_2");
        boolean removed1 = set.remove("to_remove_1");

        // assert
        assertTrue(removed1);
        assertTrue(removed2);
        assertTrue(removed3);
        assertEquals(0, set.size());

        assertFalse(set.contains("to_remove_1"));
        assertFalse(set.contains("to_remove_2"));
        assertFalse(set.contains("to_remove_3"));
    }

    @Test
    void checkRemove_whenSetWithSeveralElementsWithSameBucketIndex() {
        // prepare
        var set = new DrfHashSet<Integer>(10);
        set.put(1);
        set.put(11);
        set.put(21);

        // action
        boolean remove1 = set.remove(1);
        boolean remove2 = set.remove(11);
        boolean remove3 = set.remove(21);

        // assert
        assertTrue(remove1);
        assertTrue(remove2);
        assertTrue(remove3);

        assertEquals(0, set.size());
    }

    @Test
    void checkCapacityCorrectness_whenInitValueLowerThanZero() throws Exception {
        // prepare
        var map = new DrfHashSet<String>(-20);

        // assert
        int capacity = getPrivateFirstValue(map, "capacity");
        assertEquals(1, capacity);
    }

    @Test
    void checkCapacityCorrectness_whenInitValueEqualTOZero() throws Exception {
        // prepare
        var map = new DrfHashSet<String>(0);

        // assert
        int capacity = getPrivateFirstValue(map, "capacity");
        assertEquals(1, capacity);
    }

    @Test
    void checkCapacityCorrectness_whenInitValueBiggerThanMaximumValue() throws Exception {
        // prepare
        var map = new DrfHashSet<String>(1 << 30);

        // assert
        int capacity = getPrivateFirstValue(map, "capacity");
        assertEquals((1 << 20), capacity);
    }

    @Test
    void checkLoadFactorCorrectness_whenInitValueLowerThanZero() throws Exception {
        // prepare
        var map = new DrfHashSet<String>(10, -1.0f);

        // assert
        float loadFactor = getPrivateFirstValue(map, "loadFactor");
        assertEquals(0.15f, loadFactor);
    }

    @Test
    void checkLoadFactorCorrectness_whenInitValueEqualsToZero() throws Exception {
        // prepare
        var map = new DrfHashSet<String>(10, 0.0f);

        // assert
        float loadFactor = getPrivateFirstValue(map, "loadFactor");
        assertEquals(0.15f, loadFactor);
    }

    @Test
    void checkLoadFactorCorrectness_whenInitValueLowerThanMinimum() throws Exception {
        // prepare
        var map = new DrfHashSet<String>(10, 0.09f);

        // assert
        float loadFactor = getPrivateFirstValue(map, "loadFactor");
        assertEquals(0.15f, loadFactor);
    }

    @Test
    void checkLoadFactorCorrectness_whenInitValueBiggerThanMaximum() throws Exception {
        // prepare
        var map = new DrfHashSet<String>(10, 1.1f);

        // assert
        float loadFactor = getPrivateFirstValue(map, "loadFactor");
        assertEquals(1.0f, loadFactor);
    }

    @Test
    void checkCapacityCorrectness_whenInitValueIsCorrect() throws Exception {
        // prepare
        var map = new DrfHashSet<String>(197);

        // assert
        int capacity = getPrivateFirstValue(map, "capacity");
        assertEquals(197, capacity);
    }

    @Test
    void checkLoadFactorCorrectness_whenInitValueIsCorrect() throws Exception {
        // prepare
        var map = new DrfHashSet<String>(10, 0.87f);

        // assert
        float loadFactor = getPrivateFirstValue(map, "loadFactor");
        assertEquals(0.87f, loadFactor);
    }
}

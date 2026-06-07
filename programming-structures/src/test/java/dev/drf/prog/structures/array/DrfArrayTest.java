package dev.drf.prog.structures.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DrfArrayTest {
    @Test
    void checkLength_emptyArray() {
        // prepare
        var arr = new DrfArray<String>();

        // action
        int len = arr.len();

        // assert
        assertEquals(0, len);
    }

    @Test
    void checkLength_emptyArrayWithCapacity() {
        // prepare
        var arr = new DrfArray<String>(10);

        // action
        int len = arr.len();

        // assert
        assertEquals(0, len);
    }

    @Test
    void checkIsEmpty_emptyArray() {
        // prepare
        var arr = new DrfArray<String>();

        // action - assert
        assertTrue(arr.isEmpty());
    }

    @Test
    void checkIsNotEmpty_emptyArray() {
        // prepare
        var arr = new DrfArray<String>();

        // action - assert
        assertFalse(arr.isNotEmpty());
    }

    @Test
    void checkLength_whenOneObjectAdded() {
        // prepare
        var arr = new DrfArray<String>();
        arr.add("object");

        // action
        int len = arr.len();

        // assert
        assertEquals(1, len);
    }

    @Test
    void checkIsEmpty_whenOneObjectAdded() {
        // prepare
        var arr = new DrfArray<String>();
        arr.add("object");

        // action - assert
        assertFalse(arr.isEmpty());
    }

    @Test
    void checkIsNotEmpty_whenOneObjectAdded() {
        // prepare
        var arr = new DrfArray<String>();
        arr.add("object");

        // action - assert
        assertTrue(arr.isNotEmpty());
    }

    @Test
    void checkGet_whenSeveralObjectsAdded() {
        // prepare
        var arr = new DrfArray<String>(5);
        arr.add("object_1");
        arr.add("object_2");
        arr.add("object_3");
        arr.add("object_4");

        // action
        var str0 = arr.get(0);
        var str1 = arr.get(1);
        var str2 = arr.get(2);
        var str3 = arr.get(3);

        // assert
        assertEquals("object_1", str0);
        assertEquals("object_2", str1);
        assertEquals("object_3", str2);
        assertEquals("object_4", str3);
    }

    @Test
    void checkLength_whenSeveralObjectsAddedWithOverflow() {
        // prepare
        var arr = new DrfArray<String>(5);
        arr.add("object_1");
        arr.add("object_2");
        arr.add("object_3");
        arr.add("object_4");
        arr.add("object_5");
        arr.add("object_6");

        // action
        int len = arr.len();

        // assert
        assertEquals(6, len);
    }

    @Test
    void checkGet_whenSeveralObjectsAddedWithOverflow() {
        // prepare
        var arr = new DrfArray<String>(5);
        arr.add("object_1");
        arr.add("object_2");
        arr.add("object_3");
        arr.add("object_4");
        arr.add("object_5");
        arr.add("object_6");

        // action
        var str0 = arr.get(0);
        var str1 = arr.get(1);
        var str2 = arr.get(2);
        var str3 = arr.get(3);
        var str4 = arr.get(4);
        var str5 = arr.get(5);

        // assert
        assertEquals("object_1", str0);
        assertEquals("object_2", str1);
        assertEquals("object_3", str2);
        assertEquals("object_4", str3);
        assertEquals("object_5", str4);
        assertEquals("object_6", str5);
    }

    @Test
    void checkIsNotEmpty_whenOneObjectAddedByIndex() {
        // prepare
        var arr = new DrfArray<String>();
        arr.addByIndex(0, "object");

        // action - assert
        assertTrue(arr.isNotEmpty());
    }

    @Test
    void checkGet_whenOneObjectAddedByIndex() {
        // prepare
        var arr = new DrfArray<String>();
        arr.addByIndex(0, "object");

        // action
        var str = arr.get(0);

        // assert
        assertEquals("object", str);
    }

    @Test
    void checkGet_whenSeveralObjectAddedByIndex() {
        // prepare
        var arr = new DrfArray<String>(5);
        arr.addByIndex(0, "object_0");
        arr.addByIndex(1, "object_1");
        arr.addByIndex(2, "object_2");
        arr.addByIndex(3, "object_3");

        // action
        var str0 = arr.get(0);
        var str1 = arr.get(1);
        var str2 = arr.get(2);
        var str3 = arr.get(3);

        // assert
        assertEquals("object_0", str0);
        assertEquals("object_1", str1);
        assertEquals("object_2", str2);
        assertEquals("object_3", str3);
    }

    @Test
    void checkGet_whenSeveralObjectAddedByIndexWithOverflow() {
        // prepare
        var arr = new DrfArray<String>();
        arr.addByIndex(0, "object_0");
        arr.addByIndex(1, "object_1");
        arr.addByIndex(2, "object_2");
        arr.addByIndex(3, "object_3");
        arr.addByIndex(4, "object_4");
        arr.addByIndex(5, "object_5");

        // action
        var str0 = arr.get(0);
        var str1 = arr.get(1);
        var str2 = arr.get(2);
        var str3 = arr.get(3);
        var str4 = arr.get(4);
        var str5 = arr.get(5);

        // assert
        assertEquals("object_0", str0);
        assertEquals("object_1", str1);
        assertEquals("object_2", str2);
        assertEquals("object_3", str3);
        assertEquals("object_4", str4);
        assertEquals("object_5", str5);
    }

    @Test
    void checkGet_whenSeveralObjectsAddedAndOneAddedByIndex() {
        // prepare
        var arr = new DrfArray<String>(5);
        arr.add("object_1");
        arr.add("object_2");
        arr.add("object_3");

        // action
        arr.addByIndex(1, "object_inserted");

        // assert
        var str0 = arr.get(0);
        var str1 = arr.get(1);
        var str2 = arr.get(2);
        var str3 = arr.get(3);

        assertEquals("object_1", str0);
        assertEquals("object_inserted", str1);
        assertEquals("object_2", str2);
        assertEquals("object_3", str3);
    }

    @Test
    void checkGet_whenSeveralObjectsAddedAndOneAddedByIndexWithOverflow() {
        // prepare
        var arr = new DrfArray<String>(5);
        arr.add("object_1");
        arr.add("object_2");
        arr.add("object_3");
        arr.add("object_4");
        arr.add("object_5");

        // action
        arr.addByIndex(1, "object_inserted");

        // assert
        var str0 = arr.get(0);
        var str1 = arr.get(1);
        var str2 = arr.get(2);
        var str3 = arr.get(3);
        var str4 = arr.get(4);
        var str5 = arr.get(5);

        assertEquals("object_1", str0);
        assertEquals("object_inserted", str1);
        assertEquals("object_2", str2);
        assertEquals("object_3", str3);
        assertEquals("object_4", str4);
        assertEquals("object_5", str5);
    }

    @Test
    void checkSet_whenArrayHaveSeveralObjects() {
        // prepare
        var arr = new DrfArray<String>(5);
        arr.add("object_0");
        arr.add("object_1");
        arr.add("object_2");

        // action
        arr.set(1, "object_set");

        // assert
        int len = arr.len();

        var str0 = arr.get(0);
        var str1 = arr.get(1);
        var str2 = arr.get(2);
        assertEquals(3, len);
        assertEquals("object_0", str0);
        assertEquals("object_set", str1);
        assertEquals("object_2", str2);
    }

    @Test
    void checkSetPreviousElement_whenArrayHaveSeveralObjects() {
        // prepare
        var arr = new DrfArray<String>(5);
        arr.add("object_0");
        arr.add("object_1");
        arr.add("object_2");

        // action
        var previous = arr.set(1, "object_set");

        // assert
        assertEquals("object_1", previous);
    }

    @Test
    void checkException_whenGetByWrongIndex() {
        // prepare
        var arr = new DrfArray<String>();
        arr.add("object");

        // action - assert
        assertThrows(IndexOutOfBoundsException.class, () -> arr.get(999));
    }

    @Test
    void checkException_whenGetByNegativeIndex() {
        // prepare
        var arr = new DrfArray<String>();
        arr.add("object");

        // action - assert
        assertThrows(IndexOutOfBoundsException.class, () -> arr.get(-1));
    }

    @Test
    void checkRemoveElement_whenArrayHaveSeveralObjects() {
        // prepare
        var arr = new DrfArray<String>(5);
        arr.add("object_0");
        arr.add("object_1");
        arr.add("object_2");

        // action
        arr.remove(1);

        // assert
        int len = arr.len();

        var str0 = arr.get(0);
        var str1 = arr.get(1);

        assertEquals(2, len);
        assertEquals("object_0", str0);
        assertEquals("object_2", str1);
    }

    @Test
    void checkPreviousObjectFromRemoveElement_whenArrayHaveSeveralObjects() {
        // prepare
        var arr = new DrfArray<String>(5);
        arr.add("object_0");
        arr.add("object_1");
        arr.add("object_2");

        // action
        var previous = arr.remove(1);

        // assert
        assertEquals("object_1", previous);
    }

    @Test
    void checkGetFirst_whenSeveralObjectsAdded() {
        // prepare
        var arr = new DrfArray<String>(5);
        arr.add("object_0");
        arr.add("object_1");
        arr.add("object_2");
        arr.add("object_3");

        // action
        var first = arr.getFirst();

        // assert
        assertEquals("object_0", first);
    }

    @Test
    void checkGetFirst_whenSeveralObjectsAddedWithOverflow() {
        // prepare
        var arr = new DrfArray<String>(5);
        arr.add("object_0");
        arr.add("object_1");
        arr.add("object_2");
        arr.add("object_3");
        arr.add("object_4");
        arr.add("object_5");

        // action
        var first = arr.getFirst();

        // assert
        assertEquals("object_0", first);
    }

    @Test
    void checkGetLast_whenSeveralObjectsAdded() {
        // prepare
        var arr = new DrfArray<String>(5);
        arr.add("object_0");
        arr.add("object_1");
        arr.add("object_2");
        arr.add("object_3");

        // action
        var last = arr.getLast();

        // assert
        assertEquals("object_3", last);
    }

    @Test
    void checkGetLast_whenSeveralObjectsAddedWithOverflow() {
        // prepare
        var arr = new DrfArray<String>(5);
        arr.add("object_0");
        arr.add("object_1");
        arr.add("object_2");
        arr.add("object_3");
        arr.add("object_4");
        arr.add("object_5");

        // action
        var last = arr.getLast();

        // assert
        assertEquals("object_5", last);
    }

    @Test
    void checkAddFirst_whenNoObjectsAdded() {
        // prepare
        var arr = new DrfArray<String>(5);

        // action
        arr.addFirst("first");

        // assert
        int len = arr.len();
        var str0 = arr.get(0);

        assertEquals(1, len);
        assertEquals("first", str0);
    }

    @Test
    void checkAddFirst_whenSeveralObjectsAdded() {
        // prepare
        var arr = new DrfArray<String>(5);
        arr.add("object_0");
        arr.add("object_1");
        arr.add("object_2");
        arr.add("object_3");

        // action
        arr.addFirst("first");

        // assert
        int len = arr.len();
        var str0 = arr.get(0);
        var str1 = arr.get(1);
        var str2 = arr.get(2);
        var str3 = arr.get(3);
        var str4 = arr.get(4);

        assertEquals(5, len);
        assertEquals("first", str0);
        assertEquals("object_0", str1);
        assertEquals("object_1", str2);
        assertEquals("object_2", str3);
        assertEquals("object_3", str4);
    }

    @Test
    void checkAddFirst_whenSeveralObjectsAddedWithOverflow() {
        // prepare
        var arr = new DrfArray<String>(5);
        arr.add("object_0");
        arr.add("object_1");
        arr.add("object_2");
        arr.add("object_3");
        arr.add("object_4");

        // action
        arr.addFirst("first");

        // assert
        int len = arr.len();
        var str0 = arr.get(0);
        var str1 = arr.get(1);
        var str2 = arr.get(2);
        var str3 = arr.get(3);
        var str4 = arr.get(4);
        var str5 = arr.get(5);

        assertEquals(6, len);
        assertEquals("first", str0);
        assertEquals("object_0", str1);
        assertEquals("object_1", str2);
        assertEquals("object_2", str3);
        assertEquals("object_3", str4);
        assertEquals("object_4", str5);
    }

    @Test
    void checkAddLast_whenNoObjectsAdded() {
        // prepare
        var arr = new DrfArray<String>(5);

        // action
        arr.addLast("last");

        // assert
        int len = arr.len();
        var str0 = arr.get(0);

        assertEquals(1, len);
        assertEquals("last", str0);
    }

    @Test
    void checkAddLast_whenSeveralObjectsAdded() {
        // prepare
        var arr = new DrfArray<String>(5);
        arr.add("object_0");
        arr.add("object_1");
        arr.add("object_2");
        arr.add("object_3");

        // action
        arr.addLast("last");

        // assert
        int len = arr.len();
        var str0 = arr.get(0);
        var str1 = arr.get(1);
        var str2 = arr.get(2);
        var str3 = arr.get(3);
        var str4 = arr.get(4);

        assertEquals(5, len);
        assertEquals("object_0", str0);
        assertEquals("object_1", str1);
        assertEquals("object_2", str2);
        assertEquals("object_3", str3);
        assertEquals("last", str4);
    }

    @Test
    void checkAddLast_whenSeveralObjectsAddedWithOverflow() {
        // prepare
        var arr = new DrfArray<String>(5);
        arr.add("object_0");
        arr.add("object_1");
        arr.add("object_2");
        arr.add("object_3");
        arr.add("object_4");

        // action
        arr.addLast("last");

        // assert
        int len = arr.len();
        var str0 = arr.get(0);
        var str1 = arr.get(1);
        var str2 = arr.get(2);
        var str3 = arr.get(3);
        var str4 = arr.get(4);
        var str5 = arr.get(5);

        assertEquals(6, len);
        assertEquals("object_0", str0);
        assertEquals("object_1", str1);
        assertEquals("object_2", str2);
        assertEquals("object_3", str3);
        assertEquals("object_4", str4);
        assertEquals("last", str5);
    }

    @Test
    void checksetFirst_whenArrayHaveSeveralObjects() {
        // prepare
        var arr = new DrfArray<String>(5);
        arr.add("object_0");
        arr.add("object_1");
        arr.add("object_2");

        // action
        arr.setFirst("object_set");

        // assert
        int len = arr.len();
        var str0 = arr.get(0);
        var str1 = arr.get(1);
        var str2 = arr.get(2);

        assertEquals(3, len);
        assertEquals("object_set", str0);
        assertEquals("object_1", str1);
        assertEquals("object_2", str2);
    }

    @Test
    void checksetFirstPreviousElement_whenArrayHaveSeveralObjects() {
        // prepare
        var arr = new DrfArray<String>(5);
        arr.add("object_0");
        arr.add("object_1");
        arr.add("object_2");

        // action
        var previous = arr.setFirst("object_set");

        // assert
        assertEquals("object_0", previous);
    }

    @Test
    void checksetLast_whenArrayHaveSeveralObjects() {
        // prepare
        var arr = new DrfArray<String>(5);
        arr.add("object_0");
        arr.add("object_1");
        arr.add("object_2");

        // action
        arr.setLast("object_set");

        // assert
        int len = arr.len();

        var str0 = arr.get(0);
        var str1 = arr.get(1);
        var str2 = arr.get(2);
        assertEquals(3, len);
        assertEquals("object_0", str0);
        assertEquals("object_1", str1);
        assertEquals("object_set", str2);
    }

    @Test
    void checksetLastPreviousElement_whenArrayHaveSeveralObjects() {
        // prepare
        var arr = new DrfArray<String>(5);
        arr.add("object_0");
        arr.add("object_1");
        arr.add("object_2");

        // action
        var previous = arr.setLast("object_set");

        // assert
        assertEquals("object_2", previous);
    }
}

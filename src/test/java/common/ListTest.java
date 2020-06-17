package common;

import org.junit.jupiter.api.Test;
import services.List;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public abstract class ListTest {

    protected abstract List<Integer> getListInstance();

    @Test
    void testAddFirst() {
        List<Integer> list = getListInstance();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        assertEquals(3, list.get(0));

    }

    @Test
    void testRemoveFirst() {
        List<Integer> list = getListInstance();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        assertEquals(3, list.removeFirst());
        assertEquals(2, list.removeFirst());
        assertEquals(1, list.removeFirst());
        assertThrows(Exception.class, () -> list.removeFirst());
    }

    @Test
    void testAddLast() {
        List<Integer> list = getListInstance();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertEquals(1, list.get(0));
        assertEquals(3, list.get(list.size() - 1));
    }

    @Test
    void testRemoveLast() {

        List<Integer> list = getListInstance();

        list.addFirst(3);
        list.addLast(4);

        list.addFirst(2);
        list.addLast(5);

        list.addFirst(1);
        list.addLast(6);

        assertEquals(6, list.removeLast());
        assertEquals(5, list.removeLast());
        assertEquals(4, list.removeLast());
        assertEquals(3, list.removeLast());
        assertEquals(2, list.removeLast());
        assertEquals(1, list.removeLast());

        assertThrows(Exception.class, () -> list.removeLast());
    }

    @Test
    void testAdd() {
        List<Integer> list = getListInstance();

        for (int i = 0; i < 10000; i++)
            list.add(i, i);

        assertEquals(10000, list.size());
        assertEquals(0, list.removeFirst());
        assertEquals(9999, list.removeLast());
    }

    @Test
    void testRemove() {
        List<Integer> list = getListInstance();

        for (int i = 0; i < 10000; i++)
            list.add(i, i);
        for (int i = 0; i < 10000; i++)
            assertEquals(i, list.remove(0));

        assertThrows(Exception.class, () -> list.remove(0));
        assertEquals(0, list.size());

    }

    @Test
    void testGet() {
        List<Integer> list = getListInstance();

        for (int i = 0; i < 10000; i++) {
            list.add(i, i);
            assertEquals(i, list.get(i));
            assertEquals(i + 1, list.size());
        }
    }

    @Test
    void testIsEmpty() {
        List<Integer> list = getListInstance();
        assertTrue(list.isEmpty());

        list.addFirst(0);
        assertFalse(list.isEmpty());
        list.removeFirst();
        assertTrue(list.isEmpty());

    }

    @Test
    void testSize() {
        List<Integer> list = getListInstance();

        for (int i = 0; i < 10000; i++)
            list.add(i, i);

        assertEquals(10000, list.size());
    }

    @Test
    void testIterator() {
        List<Integer> list = getListInstance();

        for (int i = 0; i < 10000; i++)
            list.add(i, i);

        Iterator<Integer> iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(i, iterator.next());
            i++;
        }

        assertEquals(i, list.size());

        i = 0;
        for (Integer elem : list) {
            assertEquals(i, elem);
            i++;
        }

        assertEquals(i, list.size());

        list.forEach(elem -> assertNotEquals(null, elem));

    }
}

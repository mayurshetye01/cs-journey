package common;

import datastructures.HashTable;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public abstract class BaseHashTableTest {
    public abstract HashTable<Integer, Integer> getHashTableInstance();

    @Test
    void testPutAndGet() {
        HashTable<Integer, Integer> hashTable = getHashTableInstance();
        for (int i = 0; i < 10; i++) {
            hashTable.put(i, i * 10);
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(i * 10, hashTable.get(i));
        }

        hashTable.put(null, 123);
        assertEquals(123, hashTable.get(null));

        hashTable.put(null, null);
        assertNull(hashTable.get(null));

    }

    @Test
    void testDuplicates() {
        HashTable<Integer, Integer> hashTable = getHashTableInstance();
        for (int i = 0; i < 10; i++) {
            hashTable.put(1, i * 10);
        }
        assertEquals(1, hashTable.size());
        assertEquals(90, hashTable.get(1));
    }


    @Test
    void testLargeEntries() {
        HashTable<Integer, Integer> hashTable = getHashTableInstance();
        for (int i = 0; i < 10000000; i++) {
            hashTable.put(i, i * 10);
        }
        for (int i = 0; i < 10000000; i++) {
            assertEquals(i * 10, hashTable.get(i));
        }
        assertNull(null);
    }

    @Test
    void testEmptyHashTable() {
        HashTable<Integer, Integer> hashTable = getHashTableInstance();
        assertEquals(0, hashTable.size());
        assertEquals(null, hashTable.get(123));
    }

    @Test
    void testContainsKey() {
        HashTable<Integer, Integer> hashTable = getHashTableInstance();
        hashTable.put(1, 100);
        hashTable.put(0, 100);
        hashTable.put(-1232212123, 12322);
        assertTrue(hashTable.containsKey(1));
        assertTrue(hashTable.containsKey(0));
        assertTrue(hashTable.containsKey(-1232212123));
        assertFalse(hashTable.containsKey(100));
        assertFalse(hashTable.containsKey(null));

        hashTable.put(null, 123123);
        assertTrue(hashTable.containsKey(null));
    }

    @Test
    void testEntrySet() {
        HashTable<Integer, Integer> hashTable = getHashTableInstance();
        for (int i = 0; i < 10; i++) {
            hashTable.put(i, i);
        }

        Set<HashTable.Entry<Integer, Integer>> entries = hashTable.entrySet();
        assertEquals(10, entries.size());

        entries.forEach(entry -> {
            assertNotNull(entry);
            assertNotNull(entry.getKey());
            assertNotNull(entry.getValue());
        });
    }
}

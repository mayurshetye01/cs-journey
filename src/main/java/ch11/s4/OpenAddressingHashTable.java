package ch11.s4;

import ch11.ProbeSequence;
import ch11.s3.DivisionHashCalculator;
import datastructures.HashTable;

import java.util.HashSet;
import java.util.Set;

public class OpenAddressingHashTable<K, V> implements HashTable<K, V> {
    private static final int NON_EXISTENT_KEY_INDEX = -1;

    private Entry<K, V>[] slots;
    private final ProbeSequence probeSequence;
    private final Entry<K, V> deleted;

    private final int capacity;
    private int size;

    public OpenAddressingHashTable(int capacity) {
        //this(capacity, new DoubleHashingProbeSequence(new DivisionHashCalculator(), new DivisionHashCalculator()));
        this(capacity, new LinearProbeSequence(new DivisionHashCalculator()));
    }

    public OpenAddressingHashTable(int capacity, ProbeSequence probeSequence) {
        this.capacity = capacity;
        this.slots = new Entry[capacity];
        this.probeSequence = probeSequence;
        this.size = 0;
        this.deleted = new Node(0, null);
    }

    @Override
    public void put(K key, V value) {
        int i = 0;
        boolean add = false;
        while (i < this.capacity) {
            final int index = probe(key, i);
            if (isEmptyOrDeleted(slots[index])) {
                add = true;
                size++;
            } else if (slots[index].getKey() == key) {
                add = true;
            }
            if (add) {
                slots[index] = new Node<>(key, value);
                return;
            }
            i++;
        }
        throw new IllegalStateException("Hash table is full");
    }

    @Override
    public V get(K key) {
        int slotIndex = search(key);
        return slotIndex == NON_EXISTENT_KEY_INDEX ? null : getValue(slotIndex);
    }

    @Override
    public void remove(K key) {
        int slotIndex = search(key);
        slots[slotIndex] = deleted;
        this.size--;
    }

    @Override
    public boolean containsKey(K key) {
        int slotIndex = search(key);
        return slotIndex == NON_EXISTENT_KEY_INDEX ? false : true;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entries = new HashSet<>();
        for (Entry<K, V> entry : slots) {
            if (!isEmptyOrDeleted(entry))
                entries.add(entry);
        }
        return entries;
    }

    @Override
    public int size() {
        return this.size;
    }

    private int search(K key) {
        int i = 0;
        int keyIndex = NON_EXISTENT_KEY_INDEX;
        while (i < this.capacity) {
            int index = probe(key, i);
            Entry<K, V> entry = slots[index];
            if (entry == null)     //Note that here we need to pass over DELETED keys
                break;
            K currKey = entry.getKey();

            if ((key == null && currKey == null) || (key != null && key.equals(currKey))) {
                keyIndex = index;
                break;
            }
            i++;
        }
        return keyIndex;
    }

    private boolean isEmptyOrDeleted(Entry<K, V> entry) {
        return entry == null || deleted.equals(entry);
    }

    private int probe(K key, int i) {
        int hashCode = key == null ? 0 : key.hashCode();
        return this.probeSequence.probe(Math.abs(hashCode), i, this.capacity);
    }

    private V getValue(int index) {
        Entry<K, V> entry = slots[index];
        return isEmptyOrDeleted(entry) ? null : entry.getValue();
    }

    private static class Node<K, V> implements Entry<K, V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }
    }
}

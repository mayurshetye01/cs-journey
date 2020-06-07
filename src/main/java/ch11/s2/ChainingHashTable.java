package ch11.s2;

import ch10.s2.SinglyLinkedList;
import ch11.HashCalculator;
import ch11.s3.DivisionHashCalculator;
import datastructures.HashTable;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class ChainingHashTable<K, V> implements HashTable<K, V> {

    private final int capacity;
    private static final int DEFAULT_CAPACITY = 8192;
    private SinglyLinkedList<Entry<K, V>>[] slots;
    private final HashCalculator hashCalculator;
    private int size;

    public ChainingHashTable() {
        this(DEFAULT_CAPACITY);
    }

    public ChainingHashTable(int capacity) {
        this(capacity, new DivisionHashCalculator());
    }

    public ChainingHashTable(HashCalculator hashCalculator) {
        this(DEFAULT_CAPACITY, hashCalculator);
    }

    public ChainingHashTable(int capacity, HashCalculator hashCalculator) {
        this.capacity = capacity;
        this.hashCalculator = hashCalculator;
        slots = new SinglyLinkedList[capacity];
        this.size = 0;
    }


    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        SinglyLinkedList<Entry<K, V>> list = getList(index);
        Entry<K, V> entry = getEntry(list, key);
        if (entry == null) {
            list.addFirst(new Node(key, value));
            size++;
        } else
            entry.setValue(value);
        slots[index] = list;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        SinglyLinkedList<Entry<K, V>> list = getList(index);
        Entry<K, V> entry = getEntry(list, key);

        return entry == null ? null : entry.getValue();
    }

    @Override
    public void remove(K key) {
        int index = getIndex(key);
        SinglyLinkedList<Entry<K, V>> list = getList(index);

        //TODO -> add

        throw new UnsupportedOperationException("Operation not supported currently");
        // size--;
    }

    @Override
    public boolean containsKey(K key) {
        int index = getIndex(key);
        SinglyLinkedList<Entry<K, V>> list = getList(index);
        Iterator<Entry<K, V>> iterator = list.iterator();
        boolean containsKey = false;
        while (iterator.hasNext()) {
            Entry currEntry = iterator.next();
            if (currEntry.getKey() == null && key == null || currEntry.getKey().equals(key)) {
                containsKey = true;
                break;
            }
        }
        return containsKey;
    }

    @Override
    //TODO -> Highly inefficient
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entrySet = new HashSet<>();

        for (int i = 0; i < slots.length; i++) {
            SinglyLinkedList<Entry<K, V>> entries = slots[i];
            if (entries == null || entries.isEmpty())
                continue;
            entries.forEach(entry -> entrySet.add(entry));
        }
        return entrySet;
    }

    @Override
    public int size() {
        return this.size;
    }

    private int hashcode(int index) {
        return this.hashCalculator.calculate(Math.abs(index), this.capacity);
    }

    private Entry<K, V> getEntry(SinglyLinkedList<Entry<K, V>> linkedList, K key) {
        for (Entry<K, V> entry : linkedList) {
            if ((key == null && entry.getKey() == null) || entry.getKey().equals(key))
                return entry;
        }
        return null;
    }

    private int getIndex(K key) {
        return key == null ? 0 : hashcode(key.hashCode());
    }

    private SinglyLinkedList<Entry<K, V>> getList(int index) {
        if (slots[index] == null)
            return new SinglyLinkedList<>();
        return slots[index];
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

package ch11.s1;

import ch10.s2.SinglyLinkedList;
import ch11.HashCalculator;
import ch11.s2.DivisionHashCalculator;
import datastructures.HashTable;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class ChainingHashTable<K, V> implements HashTable<K, V> {

    private final int capacity;
    private static final int DEFAULT_CAPACITY = 8192;
    private SinglyLinkedList<Node<K, V>>[] slots;
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
        SinglyLinkedList<Node<K, V>> list = getList(index);
        Node<K, V> node = getNode(list, key);
        if (node == null) {
            list.addFirst(new Node(key, value));
            size++;
        } else
            node.setValue(value);
        slots[index] = list;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        SinglyLinkedList<Node<K, V>> list = getList(index);
        Node<K, V> node = getNode(list, key);

        return node == null ? null : node.value;
    }

    @Override
    public void remove(K key) {
        int index = getIndex(key);
        SinglyLinkedList<Node<K, V>> list = getList(index);

        //TODO -> add

        throw new UnsupportedOperationException("Operation not supported currently");
        // size--;
    }

    @Override
    public boolean containsKey(K key) {
        int index = getIndex(key);
        SinglyLinkedList<Node<K, V>> list = getList(index);
        Iterator<Node<K, V>> iterator = list.iterator();
        boolean containsKey = false;
        while (iterator.hasNext()) {
            Node currNode = iterator.next();
            if (currNode.key == null && key == null || currNode.key.equals(key)) {
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
            SinglyLinkedList<Node<K, V>> entries = slots[i];
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

    private Node<K, V> getNode(SinglyLinkedList<Node<K, V>> linkedList, K key) {
        for (Node<K, V> node : linkedList) {
            if ((key == null && node.key == null) || node.key.equals(key))
                return node;
        }
        return null;
    }

    private int getIndex(K key) {
        return key == null ? 0 : hashcode(key.hashCode());
    }

    private SinglyLinkedList<Node<K, V>> getList(int index) {
        if (slots[index] == null)
            return new SinglyLinkedList<>();
        return slots[index];
    }

    static class Node<K, V> implements Entry<K, V> {
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

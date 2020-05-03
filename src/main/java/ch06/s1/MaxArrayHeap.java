package ch06.s1;

import annotations.Complexity;
import annotations.Quality;
import annotations.Stage;
import datastructures.PriorityQueue;

import java.util.Collection;
import java.util.Iterator;

/**
 * Implementation of Heap data structure as a Max Heap using resizable Arrays
 * A Priority Queue is implemented using a Max Heap
 * @param <E>
 */
@Quality(Stage.REFACTORING_REQUIRED)
public class MaxArrayHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    private static final int INITIAL_CAPACITY = 4;
    //Size of heap, size of array can be greater than or equal to heap size
    private int size = 0;
    private Object[] data;

    public MaxArrayHeap() {
        this.data = new Object[INITIAL_CAPACITY];
    }

    public MaxArrayHeap(Collection<E> items) {
        size = items.size();
        this.data = new Object[size];
        buildMaxHeap(items);
    }

    @Override
    public void clear() {
        new MaxArrayHeap();
    }

    @Override
    /**
     * Equivalent to FIND-MAX for a max heap
     */
    public E peek() {
        return get(0);
    }

    @Override
    /**
     * Equivalent to EXTRACT-MAX for a max heap
     */
    @Complexity("O(log(n))")
    public E pop() {
        E root = get(0);
        //remove element and restructure heap
        data[0] = data[size - 1];
        data[size - 1] = null;
        size--;
        heapify(0);
        checkCapacity();
        return root;
    }

    @Override
    /**
     * Equivalent to INSERT in max heap
     */
    @Complexity("O(log(n))")
    public void add(E item) {
        size++;
        checkCapacity();
        data[size - 1] = item;
        heapify(0);
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void increaseKey(int index, E newValue) {
        E curr = get(index);
        if (newValue.compareTo(curr) < 0)
            throw new IllegalArgumentException("New key cannot be smaller than current value");

        this.data[index] = newValue;
        heapify(index);
    }

    @Override
    public E get(int index) {
        if (index < 0)
            throw new IllegalArgumentException("Negative index not permissible");
        if (size == 0)
            throw new IllegalStateException("Heap underflow");
        if (index > size)
            throw new IllegalStateException("Heap overflow");

        return (E) data[index];
    }

    private int getLeft(int index) {
        return 2 * index + 1;
    }

    private int getRight(int index) {
        return 2 * index + 2;
    }

    @Complexity("O(n))")
    private void buildMaxHeap(Collection<E> items) {
        if (items == null)
            throw new IllegalArgumentException("Cannot build heap from null");

        Iterator<E> iterator = items.iterator();
        for (int i = 0; i < items.size(); i++) {
            data[i] = iterator.next();
        }

        for (int i = size / 2; i >= 0; i--) {
            heapify(i);
        }
    }

    @Complexity("O(log(n))")
    private void heapify(int index) {
        if (data == null || index >= data.length)
            return;

        int left = getLeft(index);
        int right = getRight(index);

        int largest = index;

        if (left < this.size && get(left).compareTo(get(largest)) > 0)
            largest = left;
        if (right < this.size && get(right).compareTo(get(largest)) > 0)
            largest = right;

        if (largest != index) {
            swap(index, largest);
            heapify(largest);
        }

    }

    private void swap(int index1, int index2) {
        E temp = get(index1);
        data[index1] = data[index2];
        data[index2] = temp;
    }


    /**
     * Increase or decrease size of object array as per current number of elements
     */
    private void checkCapacity() {
        final Object[] temp;
        if (size > 3 * (data.length / 4.0)) {
            temp = new Object[data.length * 2];
            System.arraycopy(data, 0, temp, 0, size);
        } else if (size < data.length / 4.0) {
            temp = new Object[(int) Math.ceil(data.length / 2.0)];
            System.arraycopy(data, 0, temp, 0, size);
        } else {
            temp = data;
        }
        data = temp;
    }
}



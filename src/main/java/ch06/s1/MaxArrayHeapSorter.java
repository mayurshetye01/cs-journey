package ch06.s1;

import datastructures.Heap;
import services.Sorter;

import java.util.Arrays;

public class MaxArrayHeapSorter<E extends Comparable<E>> implements Sorter<E> {

    @Override
    public void sort(E[] items) {
        Heap<E> heap = new MaxArrayHeap<>(Arrays.asList(items));
        for (int i = heap.size() - 1; i >= 0; i--) {
            //The root element of the heap is always the max element
            items[i] = heap.pop();
        }
    }
}

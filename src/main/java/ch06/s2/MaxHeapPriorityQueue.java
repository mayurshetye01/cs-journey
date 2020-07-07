package ch06.s2;

import ch06.s1.MaxArrayHeap;

import java.util.Collection;

public class MaxHeapPriorityQueue<E extends Comparable<E>> extends MaxArrayHeap<E> {

    public MaxHeapPriorityQueue(Collection<E> items) {
        super(items);
    }
}

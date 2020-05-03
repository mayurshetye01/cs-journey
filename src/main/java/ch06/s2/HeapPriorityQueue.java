package ch06.s2;

import ch06.s1.MaxArrayHeap;

import java.util.Collection;

public class HeapPriorityQueue<E extends Comparable<E>> extends MaxArrayHeap<E> {

    public HeapPriorityQueue(Collection<E> items) {
        super(items);
    }
}

package datastructures;

public interface PriorityQueue<E extends Comparable<E>> extends Heap<E> {

    E get(int index);

    void increaseKey(int index, E newValue);
}

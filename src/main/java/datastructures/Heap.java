package datastructures;

/**
 * Datastructure which is a nearly complete Binary Tree
 * Can be implemented as a Max Heap or a Min Heap
 * @param <E>
 */
public interface Heap<E extends Comparable<E>> {
    void clear();

    E peek();

    E pop();

    void add(E item);

    boolean isEmpty();

    int size();
}

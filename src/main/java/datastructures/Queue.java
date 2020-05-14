package datastructures;

public interface Queue<E> {

    void enqueue(E item);

    E deque();

    boolean isEmpty();
}

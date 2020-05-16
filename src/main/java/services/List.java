package services;

public interface List<E> extends Iterable<E> {
    void addFirst(E item);

    E removeFirst();

    void addLast(E item);

    E removeLast();

    void add(E item, int index);

    E remove(int index);

    E get(int index);

    boolean isEmpty();

    int size();
}

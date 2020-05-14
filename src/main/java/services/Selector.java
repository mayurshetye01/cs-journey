package services;

public interface Selector<E> {

    E select(E[] items, int i);

}

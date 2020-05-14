package ch10.s1;

import datastructures.Queue;

public class ArrayQueue<E extends Comparable<E>> implements Queue<E> {

    private int head;
    private int tail;
    private Object[] data;
    private static final int DEFAULT_CAPACITY = 4;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(Integer capacity) {
        data = new Object[capacity];
        head = 0;
        tail = 0;
    }

    @Override
    public void enqueue(E item) {
        checkCapacity();

        if (tail + head == data.length)
            throw new IllegalStateException("Queue is full");

        data[tail] = item;

        //Wrap around the array
        if (tail == data.length)
            tail = 0;
        else
            tail++;

    }

    @Override
    public E deque() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");

        E item = (E) data[head];

        //Wrap around the array
        if (head == data.length)
            head = 0;
        else
            head++;

        checkCapacity();

        return item;

    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    private void checkCapacity() {
        if (isEmpty())
            return;

        int size = head + tail;
        final Object[] temp;
        if (size > 3 * (data.length / 4.0)) {
            temp = new Object[data.length * 2];
            copy(temp, size);
        } else if (size < data.length / 4.0) {
            temp = new Object[(int) Math.ceil(data.length / 2.0)];
            copy(temp, size);
        } else {
            temp = data;
        }
        data = temp;
    }

    private void copy(Object[] temp, int size) {
        if (head <= tail)
            System.arraycopy(data, 0, temp, 0, size);
        else {
            System.arraycopy(data, head, temp, 0, (data.length - head));
            System.arraycopy(data, 0, temp, (data.length - head + 1), tail);
        }
    }
}

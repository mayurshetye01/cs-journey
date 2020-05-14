package ch10.s1;

import datastructures.Stack;

public class ArrayStack<E extends Comparable<E>> implements Stack<E> {

    private int top;
    private Object[] data;
    private static final int DEFAULT_CAPACITY = 4;
    private static final int EMPTY_STACK_INDEX = -1;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(Integer capacity) {
        this.top = EMPTY_STACK_INDEX;
        this.data = new Object[capacity];
    }

    @Override
    public void push(E item) {
        checkCapacity();
        if (top > data.length)
            throw new IllegalStateException("Stack is full");
        top++;
        data[top] = item;
    }

    @Override
    public E pop() {
        if (top == EMPTY_STACK_INDEX)
            throw new IllegalStateException("Stack is empty");

        E item = (E) data[top];
        top--;
        checkCapacity();
        return item;
    }

    @Override
    public boolean isEmpty() {
        return this.top == EMPTY_STACK_INDEX;
    }

    private void checkCapacity() {
        int size = top + 1;
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

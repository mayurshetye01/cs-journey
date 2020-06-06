package ch10.s2;

import services.List;

import java.util.Iterator;

public class SinglyLinkedList<E> implements List<E> {

    private Node head;
    private int size;

    @Override
    public void addFirst(E item) {
        add(item, 0);
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public void addLast(E item) {
        add(item, size());
    }

    @Override
    public E removeLast() {
        return remove(size() - 1);
    }

    @Override
    public void add(E item, int index) {
        if (index < 0 || index > size())
            throw new ArrayIndexOutOfBoundsException(index);
        if (index == 0) {
            Node<E> node = new Node<>(item);
            node.next = head;
            head = node;
        } else {
            Node node = new Node(item);

            Node<E> left = find(index - 1);
            Node<E> right = left.next;
            left.next = node;
            node.next = right;
        }

        size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size())
            throw new ArrayIndexOutOfBoundsException(index);
        Node<E> item;
        if (index == 0) {
            item = head;
            head = head.next;
        } else {
            Node<E> prev = find(index - 1);
            item = prev.next;
            Node<E> newNext = item.next;
            prev.next = newNext;
        }
        size--;
        return item.data;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size())
            throw new ArrayIndexOutOfBoundsException(index);

        Node<E> item = find(index);
        return (item == null ? null : item.data);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private Node<E> find(int index) {
        Node<E> curr = head;
        while (index > 0) {
            curr = curr.next;
            index--;
        }
        return curr;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> curr = head;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public E next() {
                Node<E> temp = curr;
                curr = curr.next;
                return temp.data;
            }
        };
    }

    private class Node<E> {
        E data;
        Node next;

        public Node(E item) {
            data = item;
        }
    }
}

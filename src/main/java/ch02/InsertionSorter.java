package ch02;

import common.Sorter;

import java.util.Comparator;

public class InsertionSorter<E extends Comparable<E>> implements Sorter<E> {

    private final Comparator<E> comparator;

    InsertionSorter(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public void sort(E[] items) {
        for (int i = 1; i < items.length; i++) {
            E key = items[i];
            // Sort the sub-array from 0 to i - 1
            int j = i - 1;
            while (j >= 0 && comparator.compare(items[j], key) > 0) {
                items[j + 1] = items[j];
                j--;
            }
            items[j + 1] = key;
        }
    }
}

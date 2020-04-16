package ch02;

import common.Sorter;

import java.lang.reflect.Array;
import java.util.Comparator;

public class MergeSorter<E extends Comparable> implements Sorter<E> {
    private final Comparator<E> comparator;

    MergeSorter(Comparator<E> comparator){
        this.comparator = comparator;
    }

    public void sort(E[] items) {
        sort(items, 0, items.length);
    }

    private void sort(E[] array, int from, int to){
        // 'from' , 'to' and 'mid' are indices of array
        // If less than 2 elements, no need to sort
        if(to - from < 2)
            return;

        int mid = from + (to - from)/2;
        sort(array, from, mid);
        sort(array, mid, to);
        merge(array, from, mid, to);
    }

    private void merge(E[] array, int from, int mid, int to){
        E[] left = (E[]) Array.newInstance(array.getClass().getComponentType(), mid - from);
        E[] right = (E[]) Array.newInstance(array.getClass().getComponentType(), to - mid);

        System.arraycopy(array, from, left, 0, left.length);
        System.arraycopy(array, mid, right, 0, right.length);

        // Main array index to which an element from left or right array will be copied to
        int cursor = from;

        // Cursors in left and right arrays, denoting smallest element not yet copied to main array
        int leftCursor = 0;
        int rightCursor = 0;
        while (cursor < to){
            E leftItem = leftCursor < left.length ? left[leftCursor] : null;
            E rightItem= rightCursor < right.length ? right[rightCursor] : null;

            // The null checks are important as we cannot assign INFINITY as extra element to left and right arrays
            if(leftItem == null){
                array[cursor] = rightItem;
                rightCursor++;
            }
            else if(rightItem == null){
                array[cursor] = leftItem;
                leftCursor++;
            }
            else if(comparator.compare(leftItem, rightItem) < 0){
                array[cursor] = leftItem;
                leftCursor++;
            }
            else {
                array[cursor] = rightItem;
                rightCursor++;
            }
            cursor++;
        }
    }


}

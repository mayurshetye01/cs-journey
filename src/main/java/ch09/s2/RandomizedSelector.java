package ch09.s2;

import annotations.Complexity;
import services.Selector;

import java.util.concurrent.ThreadLocalRandom;

import static commons.utils.ArrayUtils.swap;

public class RandomizedSelector<E extends Comparable<E>> implements Selector<E> {
    @Override
    // order goes from 0 .. n
    public E select(E[] items, int order) {
        return select(items, order, 0, items.length - 1);
    }

    @Complexity(value = "O(n)", explanation = "Expected running time O(n). " +
            "Worst case O(n^2) if partition always happens around max value")
    private E select(E[] items, int order, int from, int to) {
        if (from > to)
            throw new IllegalArgumentException("Invalid arguments to select values");

        if (from == to)
            return items[from];

        int pivot = partition(items, from, to);

        int k = pivot - from + 1;

        if (order == k)
            return items[pivot];

        else if (order < k)
            return select(items, order, from, pivot - 1);

        else
            // k means that there are k smallest elements in lower partition.
            // So we need to find the remaining (order - k) in higher partition
            return select(items, (order - k), pivot + 1, items.length - 1);
    }

    //Partition subroutine same as in QuickSorter
    private int partition(E[] arr, int startIndex, int endIndex) {
        final int randomIndex = ThreadLocalRandom.current().nextInt(startIndex, endIndex + 1);
        swap(endIndex, randomIndex, arr);

        E pivot = arr[endIndex];
        int i = startIndex - 1;

        for (int j = startIndex; j < endIndex; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(i, j, arr);
            }
        }
        swap(i + 1, endIndex, arr);

        return i + 1;

    }
}

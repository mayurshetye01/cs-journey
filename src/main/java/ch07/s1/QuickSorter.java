package ch07.s1;

import annotations.Complexity;
import services.Sorter;

import static commons.utils.ArrayUtils.swap;

public class QuickSorter<E extends Comparable<E>> implements Sorter<E> {
    @Override
    public void sort(E[] items) {
        quickSort(items, 0, items.length - 1);
    }

    @Complexity(value = "O(n*log(n)) or O(n^2)", explanation = "Worst case will occur when partition is unbalanced for every level")
    protected void quickSort(E[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int q = partition(arr, startIndex, endIndex);
            quickSort(arr, startIndex, q - 1);
            quickSort(arr, q + 1, endIndex);
        }
    }

    /**
     * Loop invariant
     * At every iteration,
     * items to the left of j contain elements less than pivot
     * items to the right of j contain elements greater than pivot
     * In the end exchange pivot with i + 1,
     * so that every element to left of pivot is smaller than it
     * every element to right of pivot is greater than it
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    protected int partition(E[] arr, int startIndex, int endIndex) {

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

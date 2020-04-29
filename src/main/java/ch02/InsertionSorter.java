package ch02;

import annotations.Complexity;
import annotations.Quality;
import annotations.Stage;
import services.Sorter;

import java.util.Comparator;

@Quality(Stage.TESTED)
public class InsertionSorter<E extends Comparable<E>> implements Sorter<E> {

    private final Comparator<E> comparator;

    InsertionSorter(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Complexity(value = "O(n^2)", explanation = "n is the size of items array")
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

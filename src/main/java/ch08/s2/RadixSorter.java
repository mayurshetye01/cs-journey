package ch08.s2;

import annotations.Complexity;
import annotations.Quality;
import annotations.Stage;
import services.Sorter;

@Quality(Stage.TESTED)
public class RadixSorter implements Sorter<Integer> {

    @Complexity(value = "O(n)", explanation = "Assuming that values are positive")
    @Override
    public void sort(Integer[] items) {
        int digits = countDigits(items);
        for (int i = 0; i < digits; i++) {
            sort(items, i);
        }
    }

    private void sort(Integer[] items, int digit) {
        /***
         * Count sort starting from least significant digit
         */

        int[] counts = new int[10];

        for (int i = 0; i < counts.length; i++)
            counts[i] = 0;

        for (Integer item : items) {
            counts[getDigit(item, digit)]++;
        }

        for (int i = 1; i < counts.length; i++)
            counts[i] += counts[i - 1];

        Integer[] target = new Integer[items.length];

        for (int j = items.length - 1; j >= 0; j--) {
            final Integer item = items[j];
            target[counts[getDigit(item, digit)] - 1] = item;
            counts[getDigit(item, digit)]--;
        }

        System.arraycopy(target, 0, items, 0, items.length);

    }

    private int getDigit(Integer item, int digit) {
        return (int) ((item / Math.pow(10, digit)) % 10);
    }

    private int countDigits(Integer[] items) {
        int digits = 0;
        for (Integer item : items) {
            final int itemDigits = (int) Math.ceil(Math.log10(item));
            if (itemDigits > digits)
                digits = itemDigits;
        }
        return digits;
    }
}

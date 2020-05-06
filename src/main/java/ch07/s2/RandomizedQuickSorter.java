package ch07.s2;

import ch07.s1.QuickSorter;

import java.util.concurrent.ThreadLocalRandom;

import static commons.utils.ArrayUtils.swap;

public class RandomizedQuickSorter<E extends Comparable<E>> extends QuickSorter<E> {

    @Override
    protected int partition(E[] arr, int startIndex, int endIndex) {
        final int randomIndex = ThreadLocalRandom.current().nextInt(startIndex, endIndex + 1);
        swap(endIndex, randomIndex, arr);

        return super.partition(arr, startIndex, endIndex);
    }

}

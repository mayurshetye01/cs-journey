package ch06.s1;

import common.BaseSorterTest;
import services.Sorter;

public class MaxArrayHeapSorterTest<E extends Comparable<E>> extends BaseSorterTest {
    @Override
    protected Sorter<Integer> getAscendingSorter() {
        return new MaxArrayHeapSorter<>();
    }
}

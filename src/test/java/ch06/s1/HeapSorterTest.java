package ch06.s1;

import common.BaseSorterTest;
import services.Sorter;

public class HeapSorterTest extends BaseSorterTest {
    @Override
    protected Sorter<Integer> getAscendingSorter() {
        return new HeapSorter<>();
    }
}

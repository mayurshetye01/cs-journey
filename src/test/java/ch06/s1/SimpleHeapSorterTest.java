package ch06.s1;

import common.BaseSorterTest;
import services.Sorter;

public class SimpleHeapSorterTest extends BaseSorterTest {
    @Override
    protected Sorter<Integer> getAscendingSorter() {
        return new SimpleHeapSorter<>();
    }
}

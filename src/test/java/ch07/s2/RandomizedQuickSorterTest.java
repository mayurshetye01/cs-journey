package ch07.s2;

import common.BaseSorterTest;
import services.Sorter;

public class RandomizedQuickSorterTest extends BaseSorterTest {
    @Override
    protected Sorter<Integer> getAscendingSorter() {
        return new RandomizedQuickSorter<>();
    }
}

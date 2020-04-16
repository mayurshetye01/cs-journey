package ch02;

import common.BaseSorterTest;
import common.Sorter;

public class MergeSorterTest extends BaseSorterTest {
    protected Sorter<Integer> getAscendingSorter() {
        return new MergeSorter<>(NATURAL_ORDER);
    }
}

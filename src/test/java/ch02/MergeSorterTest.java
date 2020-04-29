package ch02;

import common.BaseSorterTest;
import services.Sorter;

public class MergeSorterTest extends BaseSorterTest {
    protected Sorter<Integer> getAscendingSorter() {
        return new MergeSorter<>(NATURAL_ORDER);
    }
}

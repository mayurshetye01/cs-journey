package ch02;

import common.BaseSorterTest;
import services.Sorter;

public class InsertionSorterTest extends BaseSorterTest {

    protected Sorter<Integer> getAscendingSorter() {
        return new InsertionSorter<>(NATURAL_ORDER);
    }
}

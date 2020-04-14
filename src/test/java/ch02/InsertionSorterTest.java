package ch02;

import common.BaseSorterTest;
import common.Sorter;

public class InsertionSorterTest extends BaseSorterTest {
    
    protected Sorter<Integer> getAscendingSorter() {
        return new InsertionSorter<Integer>();
    }
}

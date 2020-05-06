package ch07.s1;

import ch07.s1.QuickSorter;
import common.BaseSorterTest;
import services.Sorter;

public class QuickSorterTest extends BaseSorterTest {
    @Override
    protected Sorter<Integer> getAscendingSorter() {
        return new QuickSorter<>();
    }
}

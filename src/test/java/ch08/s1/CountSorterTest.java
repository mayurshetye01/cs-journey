package ch08.s1;

import ch08.s1.CountSorter;
import common.BaseSorterTest;
import services.Sorter;

public class CountSorterTest extends BaseSorterTest {

    @Override
    protected Sorter<Integer> getAscendingSorter() {
        return new CountSorter();
    }
}

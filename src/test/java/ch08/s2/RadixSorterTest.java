package ch08.s2;

import common.BaseSorterTest;
import jdk.nashorn.internal.ir.annotations.Ignore;
import services.Sorter;

public class RadixSorterTest extends BaseSorterTest {
    @Override
    protected Sorter<Integer> getAscendingSorter() {
        return new RadixSorter();
    }

    @Override
    //radix sort supports only positive values
    @Ignore
    public void testSortingNegativeValues() {
    }
}

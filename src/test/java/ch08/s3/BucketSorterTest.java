package ch08.s3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import services.Sorter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BucketSorterTest {

    private Sorter<Double> sorter = new BucketSorter(10);


    protected Sorter<Double> getAscendingSorter() {
        return this.sorter;
    }

    @Test
    public void testSortingEmptyArray() throws Exception {
        final Double[] items = {};
        getAscendingSorter().sort(items);
        assertArrayEquals(items, new Double[0]);
    }

    @Test
    public void testSimpleAscendingSortWithNegativeItems() throws Exception {
        final Double[] items = {-1.7, -1.9, -1.8, 1.7, 1.9, 1.8, 0.0};
        final Double[] expected = {-1.9, -1.8, -1.7, 0.0, 1.7, 1.8, 1.9};
        final int length = items.length;
        getAscendingSorter().sort(items);
        assertEquals(items.length, length);
        assertArrayEquals(items, expected);
    }

    @Test
    public void testAscendingSortWithInfinity() throws Exception {
        final Double[] items = {1., 2., 3., (double) Integer.MIN_VALUE, 0., (double) Integer.MAX_VALUE, 4., 5., 6.};
        final Double[] expected = {(double) Integer.MIN_VALUE, 0., 1., 2., 3., 4., 5., 6., (double) Integer.MAX_VALUE};
        final int length = items.length;
        getAscendingSorter().sort(items);
        assertEquals(items.length, length);
        assertArrayEquals(items, expected);
    }
}

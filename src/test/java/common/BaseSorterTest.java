package common;

import org.junit.jupiter.api.Test;
import services.Sorter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public abstract class BaseSorterTest {

    protected abstract Sorter<Integer> getAscendingSorter();

    protected static final Comparator<Integer> NATURAL_ORDER = Integer::compareTo ;

    @Test
    void testSortingNegativeValues(){
        final Integer[] items = {-7, -9, -8, 7, 9, 8, 0};
        final Integer[] expected = {-9, -8, -7, 0, 7, 8, 9};
        final int length = items.length;
        getAscendingSorter().sort(items);
        assertEquals(items.length, length);
        assertArrayEquals(items, expected);
    }

    @Test
    public void testSortingEmptyArray() {
        final Integer[] items = {};
        getAscendingSorter().sort(items);
        assertArrayEquals(items, new Integer[0]);
    }

    @Test
    public void testSortingLargeCollection() {
        final Sorter<Integer> sorter = getAscendingSorter();
        final int length = 1000;
        final Integer[] original = new Integer[length];
        final Integer[] expected = new Integer[length];
        final Random random = new Random();
        for (int i = 0; i < original.length; i++) {
            original[i] = random.nextInt(10);
        }
        System.arraycopy(original, 0, expected, 0, original.length);
        Arrays.sort(expected);
        sorter.sort(original);
        assertArrayEquals(original, expected);
    }

}

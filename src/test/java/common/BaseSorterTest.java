package common;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public abstract class BaseSorterTest {

    protected abstract Sorter<Integer> getAscendingSorter();

    protected static final Comparator<Integer> NATURAL_ORDER = Integer::compareTo ;

    @Test
    void testIntegerSort(){
        final Integer[] items = {-7, -9, -8, 7, 9, 8, 0};
        final Integer[] expected = {-9, -8, -7, 0, 7, 8, 9};
        final int length = items.length;
        getAscendingSorter().sort(items);
        assertEquals(items.length, length);
        assertArrayEquals(items, expected);
    }

}

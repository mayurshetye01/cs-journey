package common;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class BaseSorterTest {

    protected abstract Sorter<Integer> getAscendingSorter();

    @Test
    public void testIntegerSort(){
        final Integer[] items = {-7, -9, -8, 7, 9, 8, 0};
        final Integer[] expected = {-9, -8, -7, 0, 7, 8, 9};
        final int length = items.length;
        getAscendingSorter().sort(items);
        assertEquals(items.length, length);
        assertTrue(Arrays.equals(items, expected));
    }
}

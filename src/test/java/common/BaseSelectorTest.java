package common;


import org.junit.jupiter.api.Test;
import services.Selector;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BaseSelectorTest {

    protected abstract Selector<Integer> getSelector();

    @Test
    void testSelectFromPositiveValues() {
        final Integer[] items = {3, 52, 14, 4, 7, 54, 23, 22};
        int i = getRandomIndex(items.length - 1, 0);
        Integer result = getSelector().select(items, i);
        Arrays.sort(items);
        assertEquals(result, items[i - 1]);
    }

    @Test
    void testSelectFromNegativeValues() {
        final Integer[] items = {-3, 101, -4, 4, -7, 1, 0, 22};
        int i = getRandomIndex(items.length - 1, 0);
        Integer result = getSelector().select(items, i);
        Arrays.sort(items);
        assertEquals(result, items[i - 1]);
    }

    @Test
    void testSelectFromInfinity() {
        final Integer[] items = {Integer.MIN_VALUE, 52, Integer.MAX_VALUE, 4345, 4, -7, 12312, 343, -2132131232};
        int i = getRandomIndex(items.length - 1, 0);
        Integer result = getSelector().select(items, i);
        Arrays.sort(items);
        assertEquals(result, items[i - 1]);
    }

    @Test
    void testSelectFromLargeCollection() {
        final Integer[] items = {3, 52, 14, 4, 7, 54, 23, 22};
        int i = getRandomIndex(items.length - 1, 0);
        Integer result = getSelector().select(items, i);
        Arrays.sort(items);
        assertEquals(result, items[i - 1]);
    }

    private int getRandomIndex(int max, int min) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}

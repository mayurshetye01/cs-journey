package ch02;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static common.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxSubArrayFinderTest {

    @Test
    public void findMaxSubArray(){
        final int[] items = {-7, -9, -8, 7, 9, 8, -2, -5};
        MaxSubarrayFinder maxSubarrayFinder = new MaxSubarrayFinder();
        Map<String, Long> result = maxSubarrayFinder.findMaxSubArray(items);
        assertEquals(result.get(LOWEST_INDEX_KEY), 3);
        assertEquals(result.get(HIGHEST_INDEX_KEY), 5);
        assertEquals(result.get(MAX_SUM_KEY), 24);
    }

    @Test
    public void findMaxSubArrayAllPositive(){
        final int[] items = {1, 2, 3, 4, 5, 6, 7, 8};
        int sum = 0;
        for (int i = 0; i < items.length; i++)
            sum += items[i];
        MaxSubarrayFinder maxSubarrayFinder = new MaxSubarrayFinder();
        Map<String, Long> result = maxSubarrayFinder.findMaxSubArray(items);
        assertEquals(result.get(LOWEST_INDEX_KEY), 0);
        assertEquals(result.get(HIGHEST_INDEX_KEY), items.length - 1);
        assertEquals(result.get(MAX_SUM_KEY), sum);
    }
}

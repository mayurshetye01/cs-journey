package common;

import model.SubArray;
import org.junit.jupiter.api.Test;
import services.MaxSubArrayFinder;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class MaxSubArrayFinderTest {

    protected abstract MaxSubArrayFinder getMaxSubArrayFinder();

    @Test
    public void findMaxSubArray(){
        final int[] items = {-7, -9, -8, 7, 9, 8, -2, -5};
        SubArray result = getMaxSubArrayFinder().findMaxSubArray(items);
        assertEquals(result.getLeftIndex(), 3);
        assertEquals(result.getRightIndex(), 5);
        assertEquals(result.getSum(), 24);
    }

    @Test
    public void findMaxSubArrayAllPositive(){
        final int[] items = {1, 2, 3, 4, 5, 6, 7, 8};
        int sum = 0;
        for (int i = 0; i < items.length; i++)
            sum += items[i];
        SubArray result = getMaxSubArrayFinder().findMaxSubArray(items);
        assertEquals(result.getLeftIndex(), 0);
        assertEquals(result.getRightIndex(), items.length - 1);
        assertEquals(result.getSum(), sum);
    }
}

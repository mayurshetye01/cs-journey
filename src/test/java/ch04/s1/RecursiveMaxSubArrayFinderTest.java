package ch04.s1;

import ch04.s1.RecursiveMaxSubarrayFinder;
import services.MaxSubArrayFinder;
import common.MaxSubArrayFinderTest;

public class RecursiveMaxSubArrayFinderTest extends MaxSubArrayFinderTest {
    @Override
    protected MaxSubArrayFinder getMaxSubArrayFinder() {
        return new RecursiveMaxSubarrayFinder();
    }
}

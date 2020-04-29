package ch04.s1;

import ch04.s1.LinearMaxSubArrayFinder;
import services.MaxSubArrayFinder;
import common.MaxSubArrayFinderTest;

public class LinearMaxSubArrayFinderTest extends MaxSubArrayFinderTest {
    @Override
    protected MaxSubArrayFinder getMaxSubArrayFinder() {
        return new LinearMaxSubArrayFinder();
    }
}

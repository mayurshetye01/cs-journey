package ch16.s1;

import common.ActivitySelectorTest;
import services.ActivitySelector;

public class IterativeGreedyActivitySelectorTest extends ActivitySelectorTest {
    @Override
    protected ActivitySelector getActivitySelector() {
        return new IterativeGreedyActivitySelector();
    }
}

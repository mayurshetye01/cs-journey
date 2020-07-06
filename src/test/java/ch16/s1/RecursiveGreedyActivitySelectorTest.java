package ch16.s1;

import common.ActivitySelectorTest;
import services.ActivitySelector;

public class RecursiveGreedyActivitySelectorTest extends ActivitySelectorTest {
    public ActivitySelector getActivitySelector(){
        return new RecursiveGreedyActivitySelector();
    }
}

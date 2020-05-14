package ch09.s2;

import common.BaseSelectorTest;
import services.Selector;

public class RandomizedSelectorTest extends BaseSelectorTest {
    @Override
    protected Selector<Integer> getSelector() {
        return new RandomizedSelector<>();
    }
}

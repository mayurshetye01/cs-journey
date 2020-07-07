package ch16.s2;

import common.KnapSackSelectorTest;
import services.KnapSackSelector;

public class WholeKnapSackSelectorTest extends KnapSackSelectorTest {
    @Override
    protected KnapSackSelector getKnapSackSelector() {
        return new WholeKnapSackSelector();
    }
}

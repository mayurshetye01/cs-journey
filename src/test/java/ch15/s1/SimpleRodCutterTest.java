package ch15.s1;

import common.BaseRodCutterTest;
import services.RodCutter;

public class SimpleRodCutterTest extends BaseRodCutterTest {

    @Override
    protected RodCutter getRodCutterType() {
        return new SimpleRodCutter();
    }
}

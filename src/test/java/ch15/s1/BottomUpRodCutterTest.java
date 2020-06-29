package ch15.s1;

import common.BaseRodCutterTest;
import services.RodCutter;

public class BottomUpRodCutterTest extends BaseRodCutterTest {
    @Override
    protected RodCutter getRodCutterType() {
        return new BottomUpRodCutter();
    }
}

package ch04.s2;

import ch04.s2.SimpleMatrixMultiplier;
import common.MatrixMultiplierTest;
import services.MatrixMultiplier;

public class SimpleMatrixMultiplierTest extends MatrixMultiplierTest {

    @Override
    public MatrixMultiplier getMatrixMultiplier() {
        return new SimpleMatrixMultiplier();
    }
}

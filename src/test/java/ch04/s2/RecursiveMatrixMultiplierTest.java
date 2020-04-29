package ch04.s2;

import common.MatrixMultiplierTest;
import services.MatrixMultiplier;

public class RecursiveMatrixMultiplierTest extends MatrixMultiplierTest {
    @Override
    public MatrixMultiplier getMatrixMultiplier() {
        return new RecursiveMatrixMultiplier();
    }
}

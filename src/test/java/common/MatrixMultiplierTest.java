package common;

import org.junit.jupiter.api.Test;
import services.MatrixMultiplier;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public abstract class MatrixMultiplierTest {

    public abstract MatrixMultiplier getMatrixMultiplier();

    @Test
    public void testMatrixMultiplication(){
        int[][] first = new int[][]{{2,3},{4,5}};
        int[][] second = new int[][]{{5,6},{9,7}};

        int[][] result = getMatrixMultiplier().multiplyMatrices(first, second);
        int[][] expected = new int[][]{{37, 33},{65, 59}};
        assertArrayEquals(result, expected);
    }
}

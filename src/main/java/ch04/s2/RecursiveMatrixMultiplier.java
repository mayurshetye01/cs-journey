package ch04.s2;


import annotations.Quality;
import annotations.Stage;
import services.MatrixMultiplier;

/***
 * Works only for square matrices whose size n is a power of tow
 * Runtime O(n^3)
 */

@Quality(value = Stage.REFACTORING_REQUIRED, explanation = "Use generics, represent SubMatrix using different model")
public class RecursiveMatrixMultiplier implements MatrixMultiplier {

    @Override
    public int[][] multiplyMatrices(int[][] first, int[][] second) {
        int n = first.length;
        return multiply(first, second, n, 0, 0, 0, 0);
    }

    private int[][] multiply(int[][] first, int[][] second, int n,
                             int fromRowFirst, int fromColFirst,
                             int fromRowSecond, int fromColSecond) {
        int[][] output = new int[n][n];
        if (n == 1) {
            output[0][0] = first[fromRowFirst][fromColFirst] * second[fromRowSecond][fromColSecond];
            return output;
        }
        int newSize = n / 2;

        sumMatrix(output,
                multiply(first, second, newSize, fromRowFirst, fromColFirst, fromRowSecond, fromColSecond),
                multiply(first, second, newSize, fromRowFirst, fromColFirst + newSize, fromRowSecond + newSize, fromColSecond),
                0, 0);
        sumMatrix(output,
                multiply(first, second, newSize, fromRowFirst, fromColFirst, fromRowSecond, fromColSecond + newSize),
                multiply(first, second, newSize, fromRowFirst, fromColFirst + newSize, fromRowSecond + newSize, fromColSecond + newSize),
                0, newSize);
        sumMatrix(output,
                multiply(first, second, newSize, fromRowFirst + newSize, fromColFirst, fromRowSecond, fromColSecond),
                multiply(first, second, newSize, fromRowFirst + newSize, fromColFirst + newSize, fromRowSecond + newSize, fromColSecond),
                newSize, 0);
        sumMatrix(output,
                multiply(first, second, newSize, fromRowFirst + newSize, fromColFirst, fromRowSecond, fromColSecond + newSize),
                multiply(first, second, newSize, fromRowFirst + newSize, fromColFirst + newSize, fromRowSecond + newSize, fromColSecond + newSize),
                newSize, newSize);
        return output;
    }

    private void sumMatrix(int[][] C, int[][] A, int[][] B, int rowC, int colC) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                C[i + rowC][j + colC] = A[i][j] + B[i][j];
        }
    }
}

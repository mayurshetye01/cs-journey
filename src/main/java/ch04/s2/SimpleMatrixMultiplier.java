package ch04.s2;

import annotations.Complexity;
import annotations.Quality;
import annotations.Stage;
import services.MatrixMultiplier;

@Quality(value = Stage.REFACTORING_REQUIRED, explanation = "Use generics")
public class SimpleMatrixMultiplier implements MatrixMultiplier {
    @Override
    @Complexity(value = "O(n^3)", explanation = "Brute force algorithm with 3 for loops")
    public int[][] multiplyMatrices(int[][] first, int[][] second) {

        int noOfRows = first.length;
        int noOfCols = first[0].length;

        if(noOfCols != second.length || noOfRows != second[0].length)
            throw new IllegalArgumentException("Invalid matrix dimensions for multiplication");

        int[][] result = new int[noOfRows][noOfCols];
        for (int i = 0 ; i < noOfRows; i++){
            for (int j = 0; j < noOfCols; j++){
                int sum = 0;
                for(int k = 0; k < noOfRows; k++) {
                    sum+= first[i][k]*second[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

}

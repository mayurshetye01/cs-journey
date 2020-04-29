package ch04.s1;

import annotations.Complexity;
import annotations.Quality;
import annotations.Stage;
import services.MaxSubArrayFinder;
import model.SubArray;

/***
 * The max sub array of A[1 .. j+1] is either the max sub array of A[1 .. j] or the sub array A[1 .. j+1] itself
 */

@Quality(Stage.TESTED)
public class LinearMaxSubArrayFinder implements MaxSubArrayFinder {
    @Override
    @Complexity("O(n)")
    public SubArray findMaxSubArray(int[] items) {
        if(items == null)
            return null;

        // Values for final result
        int start = 0;
        int end = 0;
        long sum = Integer.MIN_VALUE;

        int currSum = 0;
        int currStart = 0;
        for (int currEnd = 0; currEnd < items.length; currEnd++){
            currSum += items[currEnd];

            if(currSum > sum){
                sum = currSum;
                start = currStart;
                end = currEnd;
            }

            if(currSum < 0){
                currSum = 0;
                currStart = currEnd + 1;
            }

        }

        return new SubArray(start, end, sum);
    }
}

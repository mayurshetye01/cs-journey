package ch04.s1;

import annotations.Complexity;
import annotations.Quality;
import annotations.Stage;
import services.MaxSubArrayFinder;
import model.SubArray;

@Quality(Stage.TESTED)
public class RecursiveMaxSubarrayFinder implements MaxSubArrayFinder {

    // Make it static method?
    public SubArray findMaxSubArray(int[] items) {
        return findMaxSubArray(items, 0, items.length - 1);
    }

    @Complexity("O(n.lg(n))")
    private SubArray findMaxSubArray(int[] arr, int low, int high) {
        // Base case
        if (low == high)
            return new SubArray(low, high, arr[low]);

        int mid = low + (high - low) / 2;

        // Find max subarray to left of midpoint
        SubArray leftResult = findMaxSubArray(arr, low, mid);
        // Find max subarray to right of midpoint
        SubArray rightResult = findMaxSubArray(arr, mid + 1, high);
        // Find max subarray crossing midpoint
        SubArray midCrossingResult = findMaxMidpointCrossingSubArray(arr, low, mid, high);

        return getHighestSubArray(leftResult, rightResult, midCrossingResult);
    }

    @Complexity("O(n)")
    private SubArray findMaxMidpointCrossingSubArray(int[] arr, int low, int mid, int high) {
        long maxLeftSum = Long.MIN_VALUE;
        int maxLeftIndex = mid;
        long sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > maxLeftSum) {
                maxLeftSum = sum;
                maxLeftIndex = i;
            }
        }

        long maxRightSum = Long.MIN_VALUE;
        int maxRightIndex = mid + 1;
        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum += arr[j];
            if (sum > maxRightSum) {
                maxRightSum = sum;
                maxRightIndex = j;
            }
        }

        return new SubArray(maxLeftIndex, maxRightIndex, maxLeftSum + maxRightSum);
    }

    @Complexity("O(1)")
    private SubArray getHighestSubArray(SubArray leftResult, SubArray rightResult, SubArray midCrossingResult) {
        long maxLeftSum = leftResult.getSum();
        long maxRightSum = rightResult.getSum();
        long maxMidSum = midCrossingResult.getSum();

        if(maxLeftSum >= maxRightSum && maxLeftSum >= maxMidSum)
            return leftResult;
        else if(maxRightSum >= maxLeftSum && maxRightSum >= maxMidSum)
            return rightResult;
        else
            return midCrossingResult;
    }
}

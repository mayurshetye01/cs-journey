package ch02;

import java.util.HashMap;
import java.util.Map;

import static common.Constants.*;

public class MaxSubarrayFinder {

    // Make it static method?
    public Map<String, Long> findMaxSubArray(int[] items) {
        return findMaxSubArray(items, 0, items.length - 1);
    }

    private Map<String, Long> findMaxSubArray(int[] arr, int low, int high) {
        // Base case
        if (low == high)
            return buildResultMap(low, high, arr[low]);

        int mid = low + (high - low) / 2;

        // Find max subarray to left of midpoint
        Map<String, Long> leftResult = findMaxSubArray(arr, low, mid);
        // Find max subarray to right of midpoint
        Map<String, Long> rightResult = findMaxSubArray(arr, mid + 1, high);
        // Find max subarray crossing midpoint
        Map<String, Long> midCrossingResult = findMaxCrossingSubArray(arr, low, mid, high);

        return getHighestSubArray(leftResult, rightResult, midCrossingResult);
    }

    // Find the max subarray crossing the midpoint
    private Map<String, Long> findMaxCrossingSubArray(int[] arr, int low, int mid, int high) {
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

        return buildResultMap(maxLeftIndex, maxRightIndex, maxLeftSum + maxRightSum);
    }

    private Map<String, Long> buildResultMap(int maxLeftIndex, int maxRightIndex, long maxSum) {
        Map<String, Long> result = new HashMap<>();
        result.put(LOWEST_INDEX_KEY, (long) maxLeftIndex);
        result.put(HIGHEST_INDEX_KEY, (long) maxRightIndex);
        result.put(MAX_SUM_KEY, maxSum);

        return result;
    }

    private Map<String, Long> getHighestSubArray(Map<String, Long> leftResult,
                                                 Map<String, Long> rightResult, Map<String, Long> midCrossingResult) {
        long maxLeftSum = leftResult.get(MAX_SUM_KEY);
        long maxRightSum = rightResult.get(MAX_SUM_KEY);
        long maxMidSum = midCrossingResult.get(MAX_SUM_KEY);

        if(maxLeftSum >= maxRightSum && maxLeftSum >= maxMidSum)
            return leftResult;
        else if(maxRightSum >= maxLeftSum && maxRightSum >= maxMidSum)
            return rightResult;
        else
            return midCrossingResult;
    }
}

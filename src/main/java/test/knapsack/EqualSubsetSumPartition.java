package test.knapsack;

public class EqualSubsetSumPartition {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,1,1};

        System.out.println(canPartitionInEqualSumSubsets(arr));
    }

    private static boolean canPartitionInEqualSumSubsets(final int[] arr) {
        if(arr == null || arr.length == 0 )
            throw new IllegalArgumentException();

        if(arr.length%2 != 0)
            return false;

        int sum = 0;

        for(Integer num : arr)
            sum += num;

        if( sum % 2 != 0)
            return false;

        int targetSum = sum/2;

        return knapsackRecursive(arr, targetSum, 0);
    }

    private static boolean knapsackRecursive(final int[] arr, final int targetSum, int currentIndex) {
        if(targetSum == 0)
            return true;

        if( arr.length == 0 || currentIndex >= arr.length)
            return false;

        // Select current element in subset
        if(arr[currentIndex] <= targetSum){
            if (knapsackRecursive(arr, targetSum - arr[currentIndex], currentIndex+1))
                return true;
        }

        //Exclde the current element in subset
        return knapsackRecursive(arr, targetSum, currentIndex + 1);
    }
}

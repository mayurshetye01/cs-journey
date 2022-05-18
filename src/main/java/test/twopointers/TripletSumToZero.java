package test.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {
    public static void main(String[] args) {
        int[] arr = {-3, 0, 1, 2, -1, 1, -2};
        List<List<Integer>> result = getUniqueTripletsAddingToZero(arr);
        for(List<Integer> elem: result){
            System.out.print("{" + elem.get(0) + "," + elem.get(1) + "," + elem.get(2) + "}");
            System.out.println();
        }
    }

    private static List<List<Integer>> getUniqueTripletsAddingToZero(final int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            //Inorder to have only unique triplets, skip the duplicate numbers
            if(i > 0 && arr[i] == arr[i-1])
                continue;

            int curr = arr[i];
            int[] pair = getTargetSumPair(arr, -curr);
            if(pair.length != 0){
                List<Integer> triplet = List.of(curr, pair[0], pair[1]);
                result.add(triplet);
            }
        }
        return result;
    }

    private static int[] getTargetSumPair(final int[] sortedArr, final int targetSum) {
        int left = 0;
        int right = sortedArr.length - 1;
        while (left < right){
            int leftSum = sortedArr[left];
            int rightSum = sortedArr[right];

            if(leftSum + rightSum == targetSum)
                return new int[]{sortedArr[left], sortedArr[right]};

            if(leftSum + rightSum < targetSum)
                left++;
            else
                right--;
        }
        return new int[0];
    }
}

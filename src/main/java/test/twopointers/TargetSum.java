package test.twopointers;

public class TargetSum {
    public static void main(String[] args) {
        int[] sortedArr = {2,4,7,9,11,15};
        int[] pair = getPairWithTargetSum(sortedArr, 22);
        for (Integer elem : pair) {
            System.out.print(elem + ",");
        }
    }

    private static int[] getPairWithTargetSum(final int[] sortedArr, final int targetSum) {
        int left = 0;
        int right = sortedArr.length - 1;
        while (left < right){
            int sum = sortedArr[left] + sortedArr[right];
            if( sum == targetSum ){
                int[] result = new int[2];
                result[0] = sortedArr[left];
                result[1] = sortedArr[right];
                return result;
            }
            if(sum < targetSum)
                left++;
            else
                right--;
        }
        return new int[0];
    }
}

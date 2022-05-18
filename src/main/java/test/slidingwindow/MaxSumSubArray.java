package test.slidingwindow;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int[] result = getMaximumSumSubArray(arr, 3);
        for (Integer elem : result) {
            System.out.print(elem + ",");
        }
    }

    private static int[] getMaximumSumSubArray(int[] arr, int k){
        if( k > arr.length)
            throw new RuntimeException();

        int[] subArray = new int[k];

        int startPos = 0;
        int endPos = 0;

        int finalStartPos = 0;
        int finalEndPos = 0;

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum+= arr[i];
            if(endPos - startPos == k){
                if(sum > maxSum){
                    maxSum = sum;
                    finalStartPos = startPos;
                    finalEndPos = endPos;
                }
                startPos++;
            }
            endPos++;
        }
        int j=0 ;
        for(int i = finalStartPos;  i < finalEndPos; i++,j++)
            subArray[j] = arr[i];

        return subArray;
    }
}

package test.slidingwindow;

public class SmallestSubArrayWithSum {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 2, 3, 2};
        int[] result = getSmallestSubarray(arr, 7);
        for (Integer elem : result) {
            System.out.print(elem + ",");
        }
    }

    private static int[] getSmallestSubarray(int[] arr, int targetSum){
        int finalStartPos = 0;
        int finalEndPos = Integer.MAX_VALUE;
        int sum = 0;

        int startPos = 0;
        int endPos = 0;

        while(endPos < arr.length){
            sum += arr[endPos];

            while(sum >= targetSum){
                if(finalEndPos - finalStartPos >= endPos - startPos){
                    finalEndPos = endPos;
                    finalStartPos = startPos;
                }
                sum -= arr[startPos];
                startPos++;
            }
            endPos++;
        }
        int[] result = new int[finalEndPos - finalStartPos + 1];
        for(int i = 0; i < result.length; i++){
            result[i] = arr[finalStartPos];
            finalStartPos++;
        }

        return result;
    }
}

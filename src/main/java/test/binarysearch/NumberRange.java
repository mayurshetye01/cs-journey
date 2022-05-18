package test.binarysearch;

public class NumberRange {
    public static void main(String[] args) {
        int[] sortedArr = {1,2,2,4,4};

        int[] range = findNumberRange(sortedArr, 4);
        System.out.println("[" + range[0] + "," + range[1] + "]");
    }

    private static int[] findNumberRange(final int[] arr, final int num) {
        if(arr == null || arr.length == 0 || arr[0] > num || arr[arr.length-1] < num)
            return new int[]{-1,-1};

        int left = 0;
        int right = arr.length - 1;

        int keyIndex = -1;
        while (left <= right){
            int midpoint = left + (right-left)/2;

            if(arr[midpoint] == num){
                keyIndex = midpoint;
                break;
            }
            if(arr[midpoint] < num){
                left = midpoint + 1;
            }
            else
                right = midpoint - 1;
        }

        if(keyIndex != -1){
            left = keyIndex;
            right = keyIndex;

            while (left >= 0 && arr[left] == num)
                left--;
            while (right < arr.length && arr[right] == num)
                right++;
            return new int[]{left+1,right-1};
        }

        return new int[]{-1,-1};
    }
}

package test.binarysearch;

public class NumberCeiling {
    public static void main(String[] args) {
        int[] sortedArr = {2,4,5,7,8,10,19,20,21,24};

        System.out.println(findCeil(sortedArr, 0));
        System.out.println(findCeil(sortedArr, 13));
        System.out.println(findCeil(sortedArr, 5));
    }

    private static int findCeil(final int[] arr, final int num) {
        if(arr == null || arr.length == 0 || arr[0] > num || arr[arr.length-1] < num)
            return -1;

        int left = 0;
        int right = arr.length - 1;

        while (left <= right){
            int midpoint = left + (right-left)/2;

            if(arr[midpoint] == num)
                return midpoint;

            if(arr[midpoint] < num){
                left = midpoint + 1;
            }
            else
                right = midpoint - 1;
        }

        // For finding the floor, return right
        return left;
    }
}

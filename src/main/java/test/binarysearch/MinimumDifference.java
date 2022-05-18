package test.binarysearch;

public class MinimumDifference {
    public static void main(String[] args) {
        int[] arr = {1,3,4,6,7,8,19,28,39};
        int key = 25;
        int numWithMinDifference = getNumberWithMinimumDifference(arr, key);
        System.out.println(numWithMinDifference);
    }

    private static int getNumberWithMinimumDifference(final int[] arr, final int key) {
        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException();

        int left = 0;
        int right = arr.length - 1;
        while (left <= right ){
            int middle = left + (right - left)/2;
            if(arr[middle] == key)
                return arr[middle];
            if(arr[middle] < key)
                left = middle + 1 ;
            else
                right = middle - 1;
        }
        //At the end of the loop, left = right + 1;
        //Return the element with closest to the key
        if(arr[left] - key < key - arr[right])
            return arr[left];
        return arr[right];
    }
}

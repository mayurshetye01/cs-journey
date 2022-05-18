package test.binarysearch;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        //The array is sorted but the sorting order ( whether ascending or descending ) is not known
        int[] sortedArr = {2,2,5,6,7,7,7,7,8,9,10};

        int index = binarySearch(sortedArr, 7);

        System.out.println(index);
    }

    private static int binarySearch(final  int[] arr, final int num) {
        if(arr == null || arr.length == 0)
            return -1;

        boolean sortedAscending = arr[0] < arr[arr.length-1];

        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int midpoint = left + (right - left)/2 ;

            if(num == arr[midpoint])
                return midpoint;

            if(sortedAscending && num > arr[midpoint] || !sortedAscending && num < arr[midpoint] )
                left = midpoint + 1;
            else
                right = midpoint - 1;
        }

        return -1;

    }
}

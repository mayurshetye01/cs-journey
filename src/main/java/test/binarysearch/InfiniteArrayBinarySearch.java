package test.binarysearch;

public class InfiniteArrayBinarySearch {
    public static void main(String[] args) {
        int[] sortedUnknownSizeArr = {2,3,5,6,7,8,10,13,14,16,17,18,19,23,25,29};
        System.out.println(find(sortedUnknownSizeArr, 30));
    }

    private static int find(int[] arr, int num){
        if(arr == null)
            return -1;

        int start = 0;
        int end = 1;

        while(ArrayReader.get(arr, end) < num){
            int newStart = end + 1;
            end += (end - start + 1 )*2;
            start = newStart;
        }

        //Now do binary search between start and end
        return binarySearch(arr, num, start, end);
    }

    private static int binarySearch(int[] arr, int num, int left, int right){
        while (left <= right){
            int mid = left + (right-left)/2;
            if(num == ArrayReader.get(arr, mid))
                return mid;
            if(num < ArrayReader.get(arr, mid))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    // You are allowed to only use this class to read the array ( since an array with unknown size/infinite size is not technically possible)
    private static class ArrayReader{
        public static int get(int[] arr, int index){
            return index > arr.length - 1 ? Integer.MAX_VALUE : arr[index];
        }
    }
}

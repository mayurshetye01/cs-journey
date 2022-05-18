package test.binarysearch;

public class NextLetter {
    public static void main(String[] args) {
        char[] sortedArr = {'x','y','z'};

        System.out.println(findNextLetter(sortedArr, 'l'));
    }

    private static char findNextLetter(final char[] arr, final char key) {
        int left = 0;
        int right = arr.length - 1;

        if(key < arr[left] || key < arr[right])
            return arr[0];

        while (left <= right){
            int midpoint = left + (right-left)/2;

            if(arr[midpoint] == key)
                return midpoint == arr.length - 1 ? arr[0] : arr[midpoint + 1];

            if(arr[midpoint] < key){
                left = midpoint + 1;
            }
            else
                right = midpoint - 1;
        }

        return left > arr.length - 1 ? arr[0] : arr[left];
    }
}

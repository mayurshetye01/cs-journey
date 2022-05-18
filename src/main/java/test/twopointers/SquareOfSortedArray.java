package test.twopointers;

public class SquareOfSortedArray {
    public static void main(String[] args) {
        int[] sortedArr = {-2, -1, 0, 2, 3};
        int[] result = getSquaresInSortedOrder(sortedArr);
        for (Integer elem : result)
            System.out.print(elem + ",");
    }

    private static int[] getSquaresInSortedOrder(final int[] sortedArr) {
        int left = 0;
        int right = sortedArr.length - 1;

        int[] result = new int[sortedArr.length];
        int highestSqrIndex = result.length - 1;

        while (left <= right){
            int leftSqr = sortedArr[left] * sortedArr[left];
            int rightSqr = sortedArr[right] * sortedArr[right];
            if( leftSqr > rightSqr){
                result[highestSqrIndex] = leftSqr;
                left++;
            }
            else {
                result[highestSqrIndex] = rightSqr;
                right--;
            }
            highestSqrIndex--;
        }
        return result;
    }
}

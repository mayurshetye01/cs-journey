package test.binarysearch;

public class BitonicArray {
    public static void main(String[] args) {

        int[] bitonicArr = {1,2,4,6,7,9,5,3,2,0};
        System.out.println(getMaxValueInBitonicArr(bitonicArr));
    }

    private static int getMaxValueInBitonicArr(final int[] bitonicArr) {
        if(bitonicArr == null || bitonicArr.length == 0)
            throw new IllegalArgumentException();

        int left = 0;
        int right = bitonicArr.length - 1;

        while (left < right){
            int middle = left + (right - left)/2;
            //We are in descending part of the array
            if(bitonicArr[middle] > bitonicArr[middle+1])
                right = middle;
            else
                left = middle + 1;
        }
        return bitonicArr[left];
    }
}

package test.xor;

public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = {1,5,1,6,4,4,5};
        System.out.println(findSingleNumber(arr));
    }

    // XOR of number by itself is 0.
    // XOR of number by 0 is the number itself
    private static int findSingleNumber(final int[] arr) {
        if(arr == null || arr.length == 0)
            throw new UnsupportedOperationException();

        int num = arr[0];

        for(int i = 1; i < arr.length; i++)
            num = num ^ arr[i];
        return num;
    }
}

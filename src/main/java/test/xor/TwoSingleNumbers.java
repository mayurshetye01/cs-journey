package test.xor;

public class TwoSingleNumbers {
    public static void main(String[] args) {
        int[] arr = {3,1,6,13,1,2,3,6};
        int[] result = getTwoSingleNumbers(arr);
        System.out.println("[" + result[0] + "," +result[1] + "]");
    }

    private static int[] getTwoSingleNumbers(final int[] arr) {
        if(arr == null || arr.length==0)
            throw new UnsupportedOperationException();
        int num1xnum2 = arr[0];

        //XOR all numbers in array, since only num1 and num2 are single the result will be xor of the two numbers
        for(int i = 1; i < arr.length; i++)
            num1xnum2 ^= arr[i];


        // Next step is to find the two numbers from their XORs

        // Keep shifting the resultant number to find its rightmost set bit
        int rightMostSetBit = 1;   // 0001  --> Keep shifting it
        while ((num1xnum2 & rightMostSetBit) == 0){
            rightMostSetBit = rightMostSetBit << 1;
        }

        int num1 = 0;
        int num2 = 0;

        for(int num: arr){
            //digit is set
            if((num & rightMostSetBit) != 0)
                num1 ^= num;
            else
                num2 ^= num;
        }

        return new int[] {num1,num2};

    }
}

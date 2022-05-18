package test.slidingwindow;

public class AverageOfSubarrayOfSizeK {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        double[] result = getAverage(arr, 5);
        for (Double elem : result) {
            System.out.print(elem + ",");
        }
    }

    //Use sliding window approach -> O(N)
    private static double[] getAverage(int[] arr, int k){
        double[] result = new double[arr.length - k + 1];
        if(k > arr.length)
            return result;

        double sum = 0;
        for(int i = 0; i < k; i++)
            sum += arr[i];

        result[0] = sum/k;
        for(int i = 1; i + k - 1 < arr.length; i++){
            sum -= arr[i-1];
            sum += arr[i+k-1];
            result[i] = sum/k;
        }

        return result;
    }
}

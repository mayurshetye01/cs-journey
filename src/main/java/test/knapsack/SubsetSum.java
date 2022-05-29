package test.knapsack;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {1,5,7,9};
        int subsetSetSum = 8;

        Boolean[][] memory = new Boolean[arr.length][subsetSetSum+1];
        System.out.println(subsetExistsWithSum(arr, subsetSetSum, 0, memory));
    }

    private static boolean subsetExistsWithSum(final int[] arr, final int subsetSetSum, int currentIndex, Boolean[][] memory) {
        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException();

        if(subsetSetSum == 0)
            return true;

        if(currentIndex >= arr.length)
            return false;

        if(memory[currentIndex][subsetSetSum] != null)
            return memory[currentIndex][subsetSetSum];

        //Include current
        if(arr[currentIndex] <= subsetSetSum){
            if(subsetExistsWithSum(arr, subsetSetSum - arr[currentIndex], currentIndex + 1, memory)){
                memory[currentIndex][subsetSetSum] = true;
                return true;
            }
        }

        //Exclude current
        memory[currentIndex][subsetSetSum] = subsetExistsWithSum(arr, subsetSetSum, currentIndex + 1, memory);
        return memory[currentIndex][subsetSetSum];
    }
}

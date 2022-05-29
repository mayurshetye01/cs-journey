package test.knapsack;

public class BruteForceKnapsack01Recursive {
    public static void main(String[] args) {
        int[] weights = {1,2,3,5};
        int[] profits = {1,6,10,16};
        int knapsackCapacity = 7;

        Integer maxProfit = getMaxProfit(weights, profits, knapsackCapacity, 0);

        System.out.println(maxProfit);

    }

    private static Integer getMaxProfit(final int[] weights, final int[] profits, final int knapsackCapacity, int currentIndex) {
        if(knapsackCapacity <= 0 || currentIndex >= weights.length)
            return 0;

        //Select current element, if weight does not exceed the capacity
        int profit1 = 0;
        if(weights[currentIndex] <= knapsackCapacity){
            profit1 = profits[currentIndex] + getMaxProfit(weights,profits, knapsackCapacity - weights[currentIndex], currentIndex + 1);
        }

        //Skip current element
        int profit2 = getMaxProfit(weights,profits, knapsackCapacity, currentIndex + 1);

        return Math.max(profit1, profit2);
    }

}

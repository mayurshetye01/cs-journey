package test.knapsack;

public class TopDownKnapsackWithMemoization {
    public static void main(String[] args) {
        int[] weights = {1,2,3,5};
        int[] profits = {1,6,10,16};
        int knapsackCapacity = 7;

        // Array used for Memoization
        // Capacity can go from 1 till knapsackCapacity
        // The current index can go from 0 to profits.length - 1
        // Note that default value of Integer[] is null
        Integer[][] capacityIndexProfitMap = new Integer[knapsackCapacity+1][profits.length];

        Integer maxProfit = getMaxProfit(weights, profits, knapsackCapacity, 0, capacityIndexProfitMap);

        System.out.println(maxProfit);

    }

    private static Integer getMaxProfit(final int[] weights, final int[] profits, final int knapsackCapacity, int currentIndex, Integer[][] capacityIndexProfitMap) {
        if(knapsackCapacity <= 0 || currentIndex >= weights.length)
            return 0;

        if(capacityIndexProfitMap[knapsackCapacity][currentIndex] != null)
            return capacityIndexProfitMap[knapsackCapacity][currentIndex];

        //Select current element, if weight does not exceed the capacity
        int profit1 = 0;
        if(weights[currentIndex] <= knapsackCapacity)
            profit1 = profits[currentIndex] + getMaxProfit(weights,profits, knapsackCapacity - weights[currentIndex] , currentIndex + 1, capacityIndexProfitMap);

        //Skip current element
        int profit2 = getMaxProfit(weights,profits, knapsackCapacity, currentIndex + 1, capacityIndexProfitMap);

        int profit = Math.max(profit1, profit2);
        capacityIndexProfitMap[knapsackCapacity][currentIndex] = profit;
        return profit;
    }
}

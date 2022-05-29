package test.knapsack;

public class BottomUpKnapsack {
    public static void main(String[] args) {
        int[] weights = {1,2,3,5};
        int[] profits = {1,6,10,16};
        int knapsackCapacity = 7;

        int maxProfit = getMaxProfitUsingBottomUp(weights, profits, knapsackCapacity);
        System.out.println(maxProfit);
    }

    private static int getMaxProfitUsingBottomUp(final int[] weights, final int[] profits, final int knapsackCapacity) {
        int[][] currentIndexCapacityProfitMap = new int[profits.length][knapsackCapacity+1];

        for(int currentIndex = 0; currentIndex < profits.length; currentIndex++){
            for(int currentCapacity = 0; currentCapacity <= knapsackCapacity; currentCapacity++){
                int currentWeight = weights[currentIndex];

                if(currentCapacity == 0){
                    currentIndexCapacityProfitMap[currentIndex][currentCapacity] = 0;
                    continue;
                }

                if(currentIndex == 0){
                    currentIndexCapacityProfitMap[currentIndex][currentCapacity] = currentWeight <= currentCapacity ? currentWeight : 0;
                    continue;
                }

                //Select current element in profit calculation
                int profit1 = 0;
                if(currentWeight <= currentCapacity )
                    profit1 = profits[currentIndex] + currentIndexCapacityProfitMap[currentIndex-1][currentCapacity - currentWeight];

                //Skip current element in profit calculation
                int profit2 = currentIndexCapacityProfitMap[currentIndex-1][currentCapacity];

                currentIndexCapacityProfitMap[currentIndex][currentCapacity] = Math.max(profit1, profit2);

            }
        }

        return currentIndexCapacityProfitMap[profits.length-1][knapsackCapacity];
    }
}

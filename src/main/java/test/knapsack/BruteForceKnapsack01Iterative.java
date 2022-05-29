package test.knapsack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BruteForceKnapsack01Iterative {
    public static void main(String[] args) {
        int[] weights = {1,2,3,5};
        int[] profits = {1,6,10,16};
        int knapsackCapacity = 7;

        List<Integer> bestCombination = getBestCombination(weights, profits, knapsackCapacity);

        for(Integer weight: bestCombination){
            System.out.println(weight + ",");
        }
    }

    private static List<Integer> getBestCombination(final int[] weights, final int[] profits, final int knapsackCapacity) {
        if(weights == null || weights.length == 0 || profits == null || profits.length != weights.length || knapsackCapacity < 1)
            throw new IllegalArgumentException();

        List<List<Integer>> allCombinations = new ArrayList<>();
        allCombinations.add(new ArrayList<>());
        for (final Integer weight : weights) {
            List<List<Integer>> newCombinations = new ArrayList<>();

            // It is like a recursion tree
            for (List<Integer> combination : allCombinations) {
                // Skip current weight i.e add the combination as is
                List<Integer> skipCurrent = List.copyOf(combination);
                newCombinations.add(skipCurrent);

                //Select current weight i.e add the current weight in current combination
                List<Integer> selectCurrent = new ArrayList<>(List.copyOf(combination));
                selectCurrent.add(weight);
                newCombinations.add(selectCurrent);
            }
            allCombinations.clear();
            allCombinations.addAll(newCombinations);
        }

        Map<Integer,Integer> weightToProfitMap = new HashMap<>();
        for(int i = 0; i < weights.length; i++)
            weightToProfitMap.put(weights[i], profits[i]);

        //Find the best combination
        List<Integer> bestCombination = null;
        int maxProfit = Integer.MIN_VALUE;
        for(List<Integer> currentCombination: allCombinations){
            int currentWeight = getTotalWeight(currentCombination);
            if(currentWeight <= knapsackCapacity ){
                int currentProfit = getTotalProfit(currentCombination, weightToProfitMap);
                if(currentProfit > maxProfit){
                    bestCombination = currentCombination;
                    maxProfit = currentProfit;
                }
            }
        }

        return bestCombination;

    }

    private static int getTotalProfit(final List<Integer> combination, Map<Integer,Integer> weightToProfitMap) {
        int totalProfit = 0;
        for(Integer weight: combination){
            int itemProfit = weightToProfitMap.get(weight);
            totalProfit += itemProfit;
        }
        return totalProfit;
    }

    private static int getTotalWeight(final List<Integer> combination) {
        int totalWeight = 0;
        for(Integer weight: combination){
            totalWeight += weight;
        }
        return totalWeight;
    }
}

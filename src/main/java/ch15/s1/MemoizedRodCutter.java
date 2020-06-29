package ch15.s1;

import services.RodCutter;

import java.util.Map;

public class MemoizedRodCutter implements RodCutter {
    @Override
    public Double cut(Integer rodSize, Map<Integer, Double> priceFunction) {

        final Double[] prices = new Double[rodSize + 1];
        for (int i = 0; i < prices.length; i++)
            prices[i] = Double.NEGATIVE_INFINITY;

        return cut(rodSize, priceFunction, prices);

    }

    private Double cut(Integer rodSize, Map<Integer, Double> priceFunction, Double[] prices) {
        if (rodSize == 0)
            return 0.0;

        if (prices[rodSize] != Double.NEGATIVE_INFINITY)
            return prices[rodSize];

        Double maxPrice = Double.MIN_VALUE;

        for (int i = 1; i <= rodSize; i++)
            maxPrice = Math.max(maxPrice, priceFunction.get(i) + cut(rodSize - i, priceFunction, prices));

        prices[rodSize] = maxPrice;

        return maxPrice;
    }
}

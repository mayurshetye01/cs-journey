package ch15.s1;

import services.RodCutter;

import java.util.Map;

public class BottomUpRodCutter implements RodCutter {
    @Override
    public Double cut(Integer rodSize, Map<Integer, Double> priceFunction) {
        if (rodSize == 0)
            return 0.0;
        final Double[] prices = new Double[rodSize + 1];
        prices[0] = 0.0;

        for (int i = 1; i <= rodSize; i++) {
            Double maxPrice = Double.NEGATIVE_INFINITY;
            for (int j = 1; j <= i; j++)
                maxPrice = Math.max(maxPrice, priceFunction.get(j) + cut(i - j, priceFunction));
            prices[i] = maxPrice;
        }

        return prices[rodSize];
    }
}

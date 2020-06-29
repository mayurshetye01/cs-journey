package ch15.s1;

import services.RodCutter;

import java.util.Map;

public class SimpleRodCutter implements RodCutter {


    @Override
    public Double cut(Integer rodSize, Map<Integer, Double> priceFunction) {
        if (rodSize == 0)
            return 0.0;

        Double maxPrice = Double.MIN_VALUE;

        for (int i = 1; i <= rodSize; i++)
            maxPrice = Math.max(maxPrice, priceFunction.get(i) + cut(rodSize - i, priceFunction));

        return maxPrice;
    }
}

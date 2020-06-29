package services;

import java.util.Map;

public interface RodCutter {

    Double cut(Integer rodSize, Map<Integer, Double> priceFunction);
}

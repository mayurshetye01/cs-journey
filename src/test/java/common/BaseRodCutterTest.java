package common;

import org.junit.jupiter.api.Test;
import services.RodCutter;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BaseRodCutterTest {
    private final RodCutter rodCutter = getRodCutterType();

    protected abstract RodCutter getRodCutterType();

    @Test
    void testCutRod() {
        assertEquals(10.0, rodCutter.cut(4, getPriceFunction()));
    }

    @Test
    void testZeroSizeCutRod() {
        assertEquals(0.0, rodCutter.cut(0, getPriceFunction()));
    }

    private Map<Integer, Double> getPriceFunction() {
        Map<Integer, Double> priceFunction = new HashMap<>();
        priceFunction.put(1, 1.0);
        priceFunction.put(2, 5.0);
        priceFunction.put(3, 8.0);
        priceFunction.put(4, 9.0);
        priceFunction.put(5, 10.0);
        priceFunction.put(6, 17.0);
        priceFunction.put(7, 17.0);
        priceFunction.put(8, 20.0);
        priceFunction.put(9, 24.0);
        priceFunction.put(10, 30.0);

        return priceFunction;
    }

}

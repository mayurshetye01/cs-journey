package ch11.s3;

import ch11.HashCalculator;

public class MultiplicationHashCalculator implements HashCalculator {

    //Using Knuths suggested factor
    private final double factor = 0.6180339887;

    @Override
    public int calculate(int index, int capacity) {
        final double multiplied = index * factor;
        final double fraction = multiplied - Math.floor(multiplied);
        return (int) Math.floor(fraction * capacity);
    }
}

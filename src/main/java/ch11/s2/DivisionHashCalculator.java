package ch11.s2;

import ch11.HashCalculator;

public class DivisionHashCalculator implements HashCalculator {
    @Override
    public int calculate(int index, int capacity) {
        return index % capacity;
    }
}

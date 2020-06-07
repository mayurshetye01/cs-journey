package ch11.s4;

import ch11.HashCalculator;
import ch11.ProbeSequence;

public class LinearProbeSequence implements ProbeSequence {
    private final HashCalculator hashCalculator;

    public LinearProbeSequence(HashCalculator hashCalculator) {
        this.hashCalculator = hashCalculator;
    }

    @Override
    public int probe(int index, int sequence, int capacity) {
        final int hash = this.hashCalculator.calculate(index, capacity);
        final int base = hash + sequence;
        return base % capacity;
    }
}

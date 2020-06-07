package ch11.s4;

import ch11.HashCalculator;
import ch11.ProbeSequence;

public class DoubleHashingProbeSequence implements ProbeSequence {
    private final HashCalculator firstHashCalculator;
    private final HashCalculator secondHashCalculator;

    public DoubleHashingProbeSequence(HashCalculator firstHashCalculator, HashCalculator secondHashCalculator) {
        this.firstHashCalculator = firstHashCalculator;
        this.secondHashCalculator = secondHashCalculator;
    }

    @Override
    public int probe(int index, int sequence, int capacity) {
        final int firstHash = this.firstHashCalculator.calculate(index, capacity);
        final int secondHash = this.secondHashCalculator.calculate(index, capacity);

        //For null keys
        //TODO
        if (firstHash == 0 && secondHash == 0)
            return sequence;

        final int base = firstHash + (sequence * secondHash);
        return base % capacity;
    }
}

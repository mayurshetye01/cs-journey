package ch11.s4;

import ch11.HashCalculator;
import ch11.ProbeSequence;

public class QuadraticProbeSequence implements ProbeSequence {

    private final HashCalculator hashCalculator;
    private final int firstCoefficient;
    private final int secondCoefficient;


    public QuadraticProbeSequence(HashCalculator hashCalculator, int firstCoefficient, int secondCoefficient) {
        this.hashCalculator = hashCalculator;
        this.firstCoefficient = firstCoefficient;
        this.secondCoefficient = secondCoefficient;
    }

    @Override
    public int probe(int index, int sequence, int capacity) {
        final int hash = this.hashCalculator.calculate(index, capacity);
        final int base = hash + firstCoefficient * sequence + secondCoefficient * sequence * sequence;
        return base % capacity;
    }
}

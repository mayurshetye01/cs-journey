package ch08.s3;

import annotations.Complexity;
import annotations.Quality;
import annotations.Stage;
import ch02.InsertionSorter;
import services.Sorter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Quality(Stage.TESTED)
public class BucketSorter implements Sorter<Double> {

    private final int buckets;
    private final Sorter<Double> listSorter = new InsertionSorter<>((aDouble, t1) -> aDouble.compareTo(t1));

    public BucketSorter(int buckets) {
        this.buckets = buckets;
    }

    @Complexity("O(n)")
    @Override
    public void sort(Double[] items) {
        //Find max and min values so that range of buckets can be decided based on bucket value
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        for (Double item : items) {
            if (item < min)
                min = item;

            if (item > max)
                max = item;
        }

        final double bucketSize = (max - min) / (this.buckets - 1.0);

        final List<List<Double>> buckets = new ArrayList<>(this.buckets);

        for (int i = 0; i < this.buckets; i++) {
            buckets.add(new LinkedList<>());
        }

        for (Double item : items) {
            int bucketPos = (int) ((item - min) / bucketSize);
            buckets.get(bucketPos).add(item);
        }

        int copied = 0;
        for (final List<Double> bucket : buckets) {
            final Double[] values = bucket.toArray(new Double[bucket.size()]);
            this.listSorter.sort(values);
            System.arraycopy(values, 0, items, copied, values.length);
            copied += values.length;
        }

    }

}

package test.mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,5));
        intervals.add(new Interval(6,9));
        intervals.add(new Interval(7,10));
        intervals.add(new Interval(12,15));

        List<Interval> mergedIntervals = getMergedIntervals(intervals);
        for (Interval interval : mergedIntervals) {
            System.out.print("{" + interval.start + "," + interval.end + "} ");
        }
    }

    private static List<Interval> getMergedIntervals(final List<Interval> intervals) {
        // Sort all intervals such that start time are in ascending order
        intervals.sort(Comparator.comparingInt(a -> a.start));

        List<Interval> mergedIntervals = new ArrayList<>();
        Iterator<Interval> iterator = intervals.iterator();

        Interval firstInterval = iterator.next();
        int start = firstInterval.start;
        int end = firstInterval.end;

        while (iterator.hasNext()){
            Interval nextInterval = iterator.next();

            //overlapping intervals
            if(end >= nextInterval.start){
                end = Math.max(end, nextInterval.end);
            }
            //No overlapping
            else{
                mergedIntervals.add(new Interval(start, end));
                start = nextInterval.start;
                end = nextInterval.end;
            }
        }

        //Add last interval
        mergedIntervals.add(new Interval(start,end));

        return mergedIntervals;
    }

    private static class Interval {
        int start;
        int end;

        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}

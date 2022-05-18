package test.mergeintervals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class InsertInterval {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(5,7));
        intervals.add(new Interval(8,12));

        Interval inputInterval = new Interval(-1,0);

        insertInterval(intervals, inputInterval);

        List<Interval> mergedIntervals = getMergedIntervals(intervals);
        for (Interval interval : mergedIntervals) {
            System.out.print("{" + interval.start + "," + interval.end + "} ");
        }
    }

    private static void insertInterval(final List<Interval> intervals, final Interval inputInterval) {
        ListIterator<Interval> iterator = intervals.listIterator();
        while(iterator.hasNext()){
            Interval current = iterator.next();
            if(current.start < inputInterval.start){
                iterator.add(inputInterval);
                break;
            }
        }
    }

    public static List<Interval> getMergedIntervals(List<Interval> intervals){
        List<Interval> mergedIntervals = new ArrayList<>();

        Iterator<Interval> iterator = intervals.iterator();

        Interval firstInterval = iterator.next();
        int start = firstInterval.start;
        int end = firstInterval.end;

        while(iterator.hasNext()){
            final Interval nextInterval = iterator.next();
            if(end >= nextInterval.start){
                end = Math.max(end, nextInterval.end);
            }
            else {
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

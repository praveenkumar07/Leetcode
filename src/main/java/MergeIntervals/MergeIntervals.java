package MergeIntervals;

import java.util.*;

public class MergeIntervals {
    // [[1,4], [2,5], [7,9]]
    public static List<Interval> merge(List<Interval> intervals) {
        Comparator<Interval> comparator = Comparator.<Interval>comparingInt(a ->a.start).thenComparingInt(b->b.start);
        Collections.sort(intervals,comparator);
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        Interval currentInt = intervals.get(0);
        int start = currentInt.start;
        int end = currentInt.end;
        for(Interval interval:intervals){
            if(end>=interval.start){
            end = Math.max(end,interval.end);
            }else{
                mergedIntervals.add(new Interval(start,end));
                start = interval.start;
                end= interval.end;

            }
        }
        mergedIntervals.add(new Interval(start,end));
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}

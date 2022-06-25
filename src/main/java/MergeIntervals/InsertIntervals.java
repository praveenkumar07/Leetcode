package MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();
        int i=0;
        while(i<intervals.size()){
            if(intervals.get(i).end<newInterval.start){
                mergedIntervals.add(new Interval(intervals.get(i).start,intervals.get(i).end));
                i++;
            }

            while (i<intervals.size()&&newInterval.end>=intervals.get(i).start){
                newInterval.start = Math.min(newInterval.start,intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end,intervals.get(i).end);
                i++;

            }
            mergedIntervals.add(new Interval(newInterval.start,newInterval.end));
            break;
        }
        while(i<intervals.size()){
            mergedIntervals.add(new Interval(intervals.get(i).start,intervals.get(i).end));
            i++;
        }
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertIntervals.insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertIntervals.insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertIntervals.insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}

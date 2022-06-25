package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervalsLeetCode {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals,(a, b)->Integer.compare(a[0],b[0]));
        List<int[]> result = new ArrayList<>();
        int i=0;
        while(i<intervals.length){
            if(intervals[i][1]<newInterval[0]){
                result.add(new int[]{intervals[i][0],intervals[i][1]});  // skip all intervals before start of new interval interval.end < newinterval.start
                i++;
            }
            while(i<intervals.length && newInterval[1]>=intervals[i][0]){ // merge intervals if interval start is less than new interval end
                newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
                i++;
            }
            result.add(new int[]{newInterval[0],newInterval[1]});
            break;

        }
        while(i<intervals.length) {
            int start = intervals[i][0];
            int end = intervals[i++][1];
            result.add(new int[]{start,end});
        }
        return result.toArray(new int[result.size()][]);
    }
    public static void main(String[] args) {
        InsertIntervalsLeetCode insertIntervalsLeetCode = new InsertIntervalsLeetCode();
        //[[1,2],[3,5],[6,7],[8,10],[12,16]]
        int[][] input = new int[5][2];
        input[0] = new int[]{1, 2};
        input[1] = new int[]{3, 5};
        input[2] = new int[]{6, 7};
        input[3] = new int[]{8, 10};
        input[4] = new int[]{12, 16};
        System.out.print("Intervals after inserting the new interval: ");
        for (int[] interval : insertIntervalsLeetCode.insert(input, new int[]{4, 8}))
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        System.out.println();


    }
}

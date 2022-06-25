package MergeIntervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    public int minMeetingRooms(int[][] schdl) {
        Arrays.sort(schdl, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for(int i=0;i<schdl.length;i++){
            if(!pq.isEmpty() && pq.peek()[1]<=schdl[i][0]){
                pq.remove();
            }
            pq.offer(schdl[i]);
        }
        return pq.size();
    }
    public static void main(String[] args) {
        MeetingRooms2 meetingRooms = new MeetingRooms2();
        //[[1,2],[3,5],[6,7],[8,10],[12,16]]
        int[][] input = new int[3][2];
        input[0] = new int[]{0, 30};
        input[1] = new int[]{5, 10};
        input[2] = new int[]{15, 20};


        System.out.println(meetingRooms.minMeetingRooms(input));


    }
}

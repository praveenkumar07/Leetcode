package Heap;

import java.util.PriorityQueue;

public class test {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)->b-a);
    public long subArrayRanges(int[] nums) {
        long result = 0l;
        for(int i=0;i<nums.length;i++){
            if(maxHeap.isEmpty() || maxHeap.peek()>=nums[i]){
                maxHeap.add(nums[i]);
            }else{
                minHeap.add(nums[i]);
            }
            rebalanceHeap();
        }
        return 0L;
    }
    private void rebalanceHeap(){

        if(maxHeap.size()> minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }else if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    public static void main(String...args){
        test t = new test();
        t.subArrayRanges(new int[]{1,2,3});
    }
}

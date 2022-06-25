package Micro;

import java.util.Stack;

public class TrapRain {
    public int trap(int[] height) {
        int maxWater = 0;
        Stack<Integer> st = new Stack<>();
        int i=0;
        while(i<height.length){
            if(st.isEmpty() || height[st.peek()] >=height[i]){
                st.push(i++);
            }else{
                int top = st.pop();
                if(st.isEmpty()) continue;
                int dist = i-st.peek()-1;
                int ht = Math.min(height[i],height[st.peek()]) - height[top];
                maxWater+= ht * dist;
            }
        }
        return maxWater;
    }
    public static void main(String...args){
        TrapRain tp = new TrapRain();
        tp.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}

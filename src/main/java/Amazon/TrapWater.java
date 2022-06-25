package Amazon;

import java.util.Stack;

public class TrapWater {
    public int trap(int[] height){
        if (height==null) return 0;
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, maxWater = 0;
        while (i < height.length){
            if (s.isEmpty() || height[i]<=height[s.peek()]){
                s.push(i++);
            }
            else {
                int top = s.pop();
                if(s.empty()) break;
                int dist = i-s.peek()-1;
                int ht=Math.min(height[s.peek()],height[i])-height[top];
                maxWater += ht*dist;
            }
        }
        return maxWater;
    }
    public static void main(String...args){
        TrapWater trapWater = new TrapWater();
        System.out.println(trapWater.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}

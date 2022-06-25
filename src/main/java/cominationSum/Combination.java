package cominationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(result,0,target,candidates,new ArrayList<>());
        return result;
    }
    private void backTracking(List<List<Integer>> result,int start,int target ,int[] nums, List<Integer> temp){
        if(target < 0) return;
        if(target==0) result.add(temp);
        else {
            for(int i=start;i<nums.length;i++){
                if(i>start && nums[i]==nums[i-1]){
                    System.out.println("inside: "+i+" Start: "+start);
                    continue;
                }
                temp.add(nums[i]);
                backTracking(result,i+1,target-nums[i],nums,new ArrayList<>(temp));
                temp.remove(temp.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        Combination combination = new Combination();
        List<List<Integer>> result;
        //System.out.println("Here is the list of subsets: " + result);

        result = combination.combinationSum2(new int[] {10,1,2,7,6,1,5},8);
        System.out.println("Here is the list of subsets: " + result);
    }
}

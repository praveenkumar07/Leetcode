package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetsWithDuplicate {
    public static List<List<Integer>> findSubsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int size =0;
        for(int j=0;j<nums.length;j++){
            //initialize i to begin with zero
            int i =0;
            if(j>0 && nums[j] == nums[j-1]) {
                //if duplicate exists i starts after previous element . we only need to add it to current subsets not to parent subsets
                i = size;
            }
            size = subsets.size();
            while(i<size){
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(nums[j]);
                subsets.add(set);
                i++;
            }
        }
        return subsets;
    }
    public static void main(String[] args) {
        List<List<Integer>> result = subsetsWithDuplicate.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = subsetsWithDuplicate.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}

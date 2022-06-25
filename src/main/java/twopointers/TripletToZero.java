package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletToZero {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for(int i=0;i<arr.length-2;i++){
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }
            searchTwoSum(-arr[i],i,triplets,arr);
        }
        return triplets;
    }
    private static  void searchTwoSum(int targetSum ,int i,List<List<Integer>> triplets ,int[] arr){
        int left = i+1;
        int right = arr.length-1;
        while(left<right){
            int sum = arr[left]+arr[right];
            if(targetSum == sum){
                triplets.add(Arrays.asList(-targetSum,arr[left],arr[right]));
                break;
            }else if(sum > targetSum){
                right--;
            }else{
               left++;
            }
        }
    }
    public static void main(String[] args) {
       System.out.println(TripletToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
       System.out.println(TripletToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
       System.out.println(TripletToZero.searchTriplets(new int[] {0, -1, 2, -3, 1}));
       System.out.println(TripletToZero.searchTriplets(new int[] {0, -2, 5, -3, 2}));
    }
}

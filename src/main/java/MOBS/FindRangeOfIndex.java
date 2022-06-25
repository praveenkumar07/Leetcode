package MOBS;

class FindRangeOfIndex {

    public static int[] findRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        result[0] = returnIndex(nums,target,true);
        result[1] = returnIndex(nums,target,false);
        return result;
    }
    private static int returnIndex(int[] nums, int target , boolean isFirst){
        int end = nums.length -1;
        int start =0;
        int value = -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(nums[mid]> target){
                end = mid -1;
            }else if(nums[mid]<target){
                start = mid +1;
            }else{
                value = mid;
                if(isFirst){
                    end = mid-1; // check to see if we find the isFirst element
                }else{
                    start = mid+1; // check to see second element
                }
            }
        }
        return value;
    }
    public static void main(String[] args) {
        int[] result = FindRangeOfIndex.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRangeOfIndex.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRangeOfIndex.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
}

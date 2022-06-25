public class Arrays {
    public static int maxProduct(int[] nums) {
        int max= Integer.MIN_VALUE;
        int current_max =1;
        int current_min =1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                current_max=0;
                current_min=0;
            }
            int temp = current_max* nums[i];
            current_max = Math.max(nums[i],Math.max(current_max*nums[i] , current_min * nums[i]));
            current_min = Math.min(nums[i],Math.min(temp,  current_min * nums[i]));
            System.out.println(current_max);
            max = Math.max(max,current_max);
        }
        return max;
    }
    public static void main(String[] args){
        Arrays.maxProduct(new int[]{-4,-3,-2});

    }
}

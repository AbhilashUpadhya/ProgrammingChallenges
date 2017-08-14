public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int max_element = nums[0];
        for(int x: nums){
            if(x > max_element) max_element = x;
        }
        max_element = (max_element < 0) ? max_element : 0;
        int max = max_element;
        int result_so_far = 0;
        for(int i=0; i<nums.length; i++){
            result_so_far += nums[i];
            if(result_so_far < max_element) result_so_far = max_element;
            if(result_so_far > max) max = result_so_far;
        }
        return max;
    }
}

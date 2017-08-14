/**
public class Solution {
    public int rob(int[] nums) {

        Relation
        f(1) =  rob1
        f(2) =  max(rob1, rob2)
        f(3) =  max(f(1) + rob3, f(2))
        f(4) =  max(f(2) + rob4, f(3))
        f(n) =  max(f(n-2) + robn, f(n-1))
 
        int len = nums.length;
        if      (len == 0 ) return 0;
        else if (len == 1 ) return nums[0];
        else if (len == 2 ) return Math.max(nums[0], nums[1]);
        else                return Math.max(rob(Arrays.copyOf(nums, len-2)) + nums[len -1], rob(Arrays.copyOf(nums, len-1)));
        
            
    }
}

*/

public class Solution {
    public int rob(int[] nums) {
/**
        Relation
        f(1) =  rob1
        f(2) =  max(rob1, rob2)
        f(3) =  max(f(1) + rob3, f(2))
        f(4) =  max(f(2) + rob4, f(3))
        f(n) =  max(f(n-2) + robn, f(n-1))
 */
    int len = nums.length;
    if      (len == 0)   return 0;
    else if (len == 1)  return nums[0];
    else {
        nums[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i< len; i++){
            nums[i]  = Math.max(nums[i-2] + nums[i], nums[i-1]);
        } 
        
    }
        return nums[len - 1];
    }
}

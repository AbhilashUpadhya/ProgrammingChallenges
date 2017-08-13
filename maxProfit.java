/**
Kadane's Algorithm 
Initialize:
    max_so_far = 0
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_ending_here < 0)
            max_ending_here = 0
  (c) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
return max_so_far
*/

public class Solution {
    public int maxProfit(int[] prices) {
        int max =0;
        int result_so_far = 0;
        if (prices.length == 0 || prices.length == 1) return 0;
        for(int i=1; i< prices.length; i++){
            result_so_far = Math.max(0, result_so_far + (prices[i] - prices[i-1]));
            if (result_so_far > max) max = result_so_far;    
        }    
        return max;
    }
    
}

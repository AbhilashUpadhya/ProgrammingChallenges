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

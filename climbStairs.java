public class Solution {
    public int climbStairs(int n) {
        int n1 = 1; 
        int n2 = 2;
        if(n == 0 ) return 0;
        else if (n == 1) return 1;
        else if (n == 2) return 2;                
        else {
            while (n - 2 >0){
                n2 = n1 + n2;
                n1 = n2 - n1;
                n--;
            }
            return n2;
        }
    }
    
}

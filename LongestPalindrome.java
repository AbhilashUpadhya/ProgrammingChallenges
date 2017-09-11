class Solution {
    public String LongestPalindrome(String s) {
     int len = s.length();
        boolean[][]dp = new boolean[len][len];
        
        for(int i=0; i<len; i++)
            dp[i][i] = true;
        
        int start = 0;
        int maxLength =1;
        for(int i=0; i<len-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                start = i;
                maxLength = 2;
            }       
        }
        
        for(int k=3; k<=len; k++){
            for(int i=0; i <= len-k; i++){
                int j = i+k-1;
                if(dp[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                  dp[i][j] = true;
                if(k > maxLength){
                    start = i;
                    maxLength = k;
                }
                    
                }
           
            }
        }
        
        return s.substring(start, start+maxLength);
        
    }
}
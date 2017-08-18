class Solution {
    public int[] countBits(int num) {
        
        int[] result = new int[num+1];
        result[0] = 0;
        if(num > 0) {
            for(int i=1; i< num + 1; i++){
                if(i % 2 == 1) result[i] = result[i-1] + 1;
                else {
                    int count = 0;
                    int j = i;
                    while (j != 0){
                        j = j >> 1;                        
                        if(j % 2 == 1) count++;
                    }
                    result[i] = count;
                }
            }    
        }
       return result; 
    }
}


/**
Best Solution
public int[] countBits(int num) {
    int[] f = new int[num + 1];
    for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
    return f;
}
*/


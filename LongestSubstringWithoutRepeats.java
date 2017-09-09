class LongestSubstringWithoutRepeats {
    public int lengthOfLongestSubstring(String s) {  
  HashMap<Character,Integer> map = new HashMap<>();
    int count =0;
    int max_count = 0;
    
    for(int i=0, j=0; i<s.length(); i++){
        if(map.containsKey(s.charAt(i))){
        j = Math.max(j, map.get(s.charAt(i)) + 1);
        map.put(s.charAt(i), i);
        count = i-j+1; 
    } else{
        map.put(s.charAt(i), i);
        count ++;        
    }        
    max_count = Math.max(count, max_count);        
   }
        return max_count;
  }
}
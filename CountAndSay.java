class CountAndSay {
    public String cSay(int n) {
        
        if (n == 0) return "";
        StringBuilder result = new StringBuilder("1");
        if (n == 1) return new String(result);
        for(int i=1; i<n; i++) {

            result = generateNextSequence(result);
        }
        return new String(result);
}
    

    StringBuilder generateNextSequence(StringBuilder result ){
        
        int count = 1;
        char element = result.charAt(0);
        int len = result.length();
      
        StringBuilder sb = new StringBuilder();
           for(int j=0; j< len-1; j++){
               
                if(result.charAt(j) == result.charAt(j+1)) count ++;
                else{
                    sb.append(Integer.toString(count) + Character.toString(element));
                    count = 1;
                    element = result.charAt(j+1);
                    }
           }
           sb.append(Integer.toString(count) + Character.toString(element));
       
      return sb;   
            
    }
    

    public static void main(String[] args){

        CountAndSay c = new CountAndSay();
        System.out.println(c.cSay(4));
    }
}
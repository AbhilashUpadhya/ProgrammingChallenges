class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        
        for(int i=0; i< rowIndex + 1; i++){
            arrList.add(0,1);
            for(int j=1; j<arrList.size() -1; j++){
                arrList.set(j, arrList.get(j) + arrList.get(j+1));
            }
        }
        return arrList;
        
    }
}
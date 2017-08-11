public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        int lenResult = (len1 <len2) ? len1 : len2;
        int[] result = new int[lenResult];
        int i= 0;
        int j= 0;
        int k=0;
        while(i<len1 && j<len2){
            if(nums1[i] < nums2[j]) i++;
            else if (nums2[j] < nums1[i]) j++;
            else {
                result[k] = nums1[i];
                    k++;
                    i++;
                    j++;
            }
                
        }
        int c = k;
        int[] returnArray = new int[k];
        for(int p=0; p<k; p++) returnArray[p] = result[p];
        return returnArray;
    }
}

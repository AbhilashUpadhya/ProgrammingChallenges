import java.io.*;
import java.util.*;

class MessedArray {

  static void sortKMessedArray(int[] arr, int k) {
    if(k==0) return;
    PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
   for(int i=0; i<k; i++)
        minheap.offer(arr[i]);
   
   //System.out.println(minheap.poll());
    for(int i=k; i<arr.length; i++){
      int x = minheap.poll();
      arr[i-k] = x;
      minheap.offer(arr[i]);
    }
    int i=0;
    while(!minheap.isEmpty()){
      arr[arr.length -k + i] = minheap.poll();
      i++;
    }
    
    for(int x: arr)
      System.out.println(x);
   /* 
   1, 2, 5, 2, 3, 7, 8, 6, 10, 9
   3,4,5
    for(int i=1; i<arr.length; i++){
      int x = arr[i];
      int j = i-1;
      while(j>=0 && arr[j]>x){
        arr[j+1] = arr[j];
        j--;
      }
      arr[j+1] = x;
    }
    return arr;
  */  
  }

  public static void main(String[] args) {
    int[] arr = {1, 4, 5, 2, 3, 7, 8, 6, 10, 9} ;
    sortKMessedArray(arr, 3);

  }

}
import java.util.*;
import java.io.*;

class DisjointSets{

	int[] parent;
	int[] rank;

	DisjointSets(int n){
		
		parent = new int[n];
		rank = new int[n];
		makeset(n);
	}
 	
 	void makeset(int n){
 		for(int i=0; i<n; i++){
 			parent[i] = i;
 			rank[i] = 1;
 		}
 	}

 	int find(int i){
 		if(parent[i] == i) return i;
 		int store = find(parent[i]);
 		parent[i] = store;
 		return store;

 	}

 	void union(int i, int j){

 		int xRoot = find(i);
 		int yRoot = find(j);

 		if(xRoot == yRoot) return;

 		if(rank[xRoot] < rank[yRoot])  parent[xRoot] = yRoot;
 		else if (rank[xRoot] > rank[yRoot]) parent[yRoot] = xRoot;
 		else {
 			parent[xRoot] = yRoot;
 			rank[yRoot]++;
 		}
 	}

 	public static void main(String[] args){

 		DisjointSets s = new DisjointSets(5);
 		
 		s.union(0,2);
 		s.union(4,2);
 		s.union(3,1);

 		System.out.println("Check if 4 and 0 are connected: ");
 		if (s.find(4) == s.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");
 
        System.out.println("Check if 1 and 0 are connected: ");
        if (s.find(1) == s.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");



 	}

}
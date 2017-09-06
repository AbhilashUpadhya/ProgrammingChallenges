import java.util.*;
import java.io.*;

class BellmanFord{
	private int V;
	private int E;
	LinkedList<Edge> edges;

	class Edge{

		int src;
		int dst;
		int weight;
	}
	
	BellmanFord(int v, int e){
		V  = v;
		E =  e;
		edges = new LinkedList<Edge>();
		
	}

	void addEdge(int src, int dst, int weight){
		Edge e = new Edge();
		e.src = src;
		e.dst = dst;
		e.weight = weight;
		edges.add(e);

	}	

	void printpaths(Integer[] dest){

		for(int i =0; i< V; i++){
			System.out.println("Shortest path cost to "+ i + " is "+dest[i]);
		}
		
	}

	void calculateShortestPaths(){
		Integer[] dest = new Integer[V];

		for(int i=1; i< V; i++)
			dest[i] = 999;

		dest[0] = 0;

		for (int i=0; i<V-1 ; i++) {
			for(Edge e: edges){
				int u = e.src;
				int v = e.dst;
				int w = e.weight;

				if(dest[v] > dest[u] + w){					
					dest[v] = dest[u] + w;

				}


			}
		}

		for(Edge e: edges){
				int u = e.src;
				int v = e.dst;
				int w = e.weight;

				if(dest[v] > dest[u] + w){					
					System.out.println("Negative cycles detected!! Aborting Algorithm...");
					return;

				}


			}
		printpaths(dest);

	}

	public static void main(String[] args){

		BellmanFord b = new BellmanFord(3,3);
		b.addEdge(0,1, 2);
		b.addEdge(1,2, 3);
		b.addEdge(2,0, -6);
		b.calculateShortestPaths();

	}


}
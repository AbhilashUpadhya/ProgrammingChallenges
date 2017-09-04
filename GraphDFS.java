import java.util.*;
import java.io.*;


class GraphDFS{

	private int V;
	private LinkedList<Integer> adj[];

	GraphDFS(int v){
		V = v;
		adj = new LinkedList[v];

		for(int i=0; i<v ; i++){
			adj[i] = new LinkedList<Integer>();
		}


	}

	void addEdge(int u, int v){
		adj[u].add(v);
	}

	void DFSVisit(int u, boolean[] visited){
		visited[u] = true;
		System.out.print(u + " --> ");
		Iterator<Integer> i = adj[u].listIterator();
		while(i.hasNext()){
			int n = i.next();
			if(!visited[n])
				DFSVisit(n, visited);
		}

	}


	void DFS(){
		boolean visited[] = new boolean[V];

		for(int i=0; i< V; i++){
			if(!visited[i])
				DFSVisit(i, visited);
		}
	}


	public static void main(String[] args){
		GraphDFS g = new GraphDFS(5);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,3);
		g.addEdge(1,2);
		g.addEdge(3,4);

		g.DFS();


	}
}
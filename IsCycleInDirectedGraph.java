import java.util.*;
import java.io.*;


class IsCycleInDirectedGraph{

	private int V;
	private LinkedList<Integer> adj[];

	IsCycleInDirectedGraph(int v){
		V = v;
		adj = new LinkedList[v];

		for(int i=0; i<v ; i++){
			adj[i] = new LinkedList<Integer>();
		}


	}

	void addEdge(int u, int v){
		adj[u].add(v);
	}

	boolean DFSVisit(int u, boolean[] visited, Stack<Integer> stack){
		visited[u] = true;
		stack.push(u);
		System.out.print(u + " --> ");
		Iterator<Integer> i = adj[u].listIterator();
		while(i.hasNext()){
			int n = i.next();
			if     (!visited[n]) 			return DFSVisit(n, visited, stack);
			else if(stack.search(n) != -1) 	return true;
		}
		return false;

	}


	boolean isCycle(){
		boolean visited[] = new boolean[V];
		Stack<Integer> stack = new Stack<Integer>();

		for(int i=0; i< V; i++){
			if(!visited[i])
				if(DFSVisit(i, visited, stack)) return true;
		}
		return false;
	}


	public static void main(String[] args){
		IsCycleInDirectedGraph g = new IsCycleInDirectedGraph(5);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,2);
		g.addEdge(2,3);
		g.addEdge(2,4);
		g.addEdge(3,0);

		if(g.isCycle())
			System.out.println(" Contains a cycle");
		else System.out.println(" No cycle");


	}
}
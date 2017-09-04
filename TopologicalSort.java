import java.util.*;
import java.io.*;


class TopologicalSort{

	private int V;
	private LinkedList<Integer> adj[];

	TopologicalSort(int v){
		V = v;
		adj = new LinkedList[v];

		for(int i=0; i<v ; i++){
			adj[i] = new LinkedList<Integer>();
		}


	}

	void addEdge(int u, int v){
		adj[u].add(v);
	}

	void DFSVisit(int u, boolean[] visited, Stack<Integer> stack){
		visited[u] = true;
		System.out.print(u + " --> ");
		Iterator<Integer> i = adj[u].listIterator();
		while(i.hasNext()){
			int n = i.next();
			if(!visited[n])
				DFSVisit(n, visited, stack);
		}
		stack.push(u);

	}


	void topologicalSort(){
		boolean visited[] = new boolean[V];
		Stack<Integer> stack = new Stack<Integer>();

		for(int i=0; i< V; i++){
			if(!visited[i])
				DFSVisit(i, visited, stack);
		}
		System.out.println("Topological Order: ");
		while(!stack.empty()){
			System.out.print(stack.pop()+ " ");
		}
	}


	public static void main(String[] args){
		TopologicalSort g = new TopologicalSort(5);
		
		
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,3);
		g.addEdge(1,2);
		g.addEdge(3,4);
		g.addEdge(2,4);

		g.topologicalSort();

		


	}
}
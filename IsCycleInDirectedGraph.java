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

	boolean DFSVisit(int u, Integer[] parent, Stack<Integer> stack){
		//visited[u] = true;
		//System.out.println("u: " +u);
		stack.push(u);
		Iterator<Integer> i = adj[u].listIterator();
		while(i.hasNext()){
			int n = i.next();
			//System.out.println("   n: " + n);
			if     (parent[n] == -999) {
					parent[n] = u;
					return DFSVisit(n, parent, stack);
			}		
			else if(stack.search(n) != -1) 	{
				int x = u;
				System.out.println("Cycle Found!!");
				
				while(x >= 0){

					System.out.print(x + " --> ");
					x= parent[x];
				}
				return true;
			}
		}
		stack.pop();
		return false;

		
	}	

	boolean isCycle(){
		Integer parent[] = new Integer[V];
		for(int i= 1; i<V; i++)
			parent[i] = -999;
		
		parent[0] = -1;

		Stack<Integer> stack = new Stack<Integer>();
		if(DFSVisit(0, parent, stack)) return true;

		for(int i=0; i< V; i++){
			if(parent[i] == -999)
				if(DFSVisit(i, parent, stack)) return true;
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

		if(g.isCycle()) System.out.println(" Contains a cycle");
		else System.out.println(" No cycle");



	}
}
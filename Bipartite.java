import java.io.*;
import java.util.*;


class Bipartite{
	private int V;
	private LinkedList<Integer> adj[];

	Bipartite(int v){
		V = v;
		adj = new LinkedList<Integer>[v];
		for(int i=0; i<v; i++)
			adj[i] = new LinkedList<Integer>(); 
	}


	void addEdge(int u, int v){
		adj[u].add(v);
	}





	void BFS(int s){
		
		boolean visited[] = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<Integer>();

		visited[s] = true;
		queue.add(s);

		while(!queue.isEmpty()){
			int q = queue.poll();
			System.out.print(q + " ");
			Iterator<Integer> al =  adj[q].listIterator();
			while(al.hasNext()){
				int n = al.next();
				if (!visited[n] ){
					visited[n] = true;
					queue.add(n);
				}
			}

		}
	}


	public static void main(String[] args){
		Bipartite g = new Bipartite(5);
	
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,2);
		g.addEdge(1,3);
		g.addEdge(2,3);
		g.addEdge(3,4);
		g.addEdge(2,4);

		g.BFS(0);

	}
}
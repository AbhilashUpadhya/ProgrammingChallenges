import java.io.*;
import java.util.*;


class Graph{
	private int V;
	private LinkedList<Integer> adj[];

	Graph(int v){
		V = v;
		adj = new LinkedList<Integer>[v];
		for(int i=0; i<v; i++)
			adj[i] = new LinkedList<Integer>(); 
	}


	void addEdge(int u, int v){
		adj[u].add(v);
	}





	void BFS(int s){

		//Create a visited array for all nodes in the graph. Mark all nodes as unvisited.
		boolean visited[] = new boolean[V];
		
		
		//Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();


		//Update s as visited and enqueue it
		visited[s] = true;
		queue.add(s);


		//loop over till queue is empty
		while(!queue.isEmpty()){

			// Pull out the first element from the queue
			int q = queue.poll();

			//Do sometging with the node you got
			System.out.print(q + " ");
			

			//Iterate through the lists
			Iterator<Integer> al =  adj[q].listIterator();
			while(al.hasNext()){
				int n = al.next();
				if (!visited[n] ) {
					visited[n] = true;
					queue.add(n);
				}
			}

		}
	}




	public static void main(String[] args){
		Graph g = new Graph(5);
	
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
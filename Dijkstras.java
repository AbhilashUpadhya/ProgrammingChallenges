import java.util.*;
import java.io.*;

class Dijkstras{

	private int V;
	LinkedList<Edge> adj[];

	class Edge{
		int adjacentNode;		
		int weight;

	}

	class Queue_elements{
		int vertex;
		int distance;
	}

	Dijkstras(int v){
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<V; i++){
			adj[i] = new LinkedList<Edge>();
		}
	}

	void addEdge(int src, int dst, int weight){
		Edge e = new Edge();		
		e.adjacentNode 	= dst;
		e.weight 	= weight;
		adj[src].add(e);

		Edge be = new Edge();
		be.adjacentNode = src;
		be.weight = weight;
		adj[dst].add(be);

	}

	void printCosts(Integer[] dest){
		for(int i=0; i< dest.length; i++)
			System.out.println("Shortest path to "+ i + " costs "+dest[i]);
	}

	void calculateShortestPath(){

		Integer[] dest = new Integer[V];
		for(int i=1; i<V; i++)
			dest[i] = 9999;

		dest[0] = 0;

		PriorityQueue<Queue_elements> pq = new PriorityQueue<Queue_elements>(V, new Comparator<Queue_elements>(){
			public int compare(Queue_elements o1, Queue_elements o2) {
				
				return o1.distance - o2.distance;
			}

		});


		Queue_elements[] elements = new Queue_elements[V];
		for(int i =0; i< V; i++){
			 elements[i] = new Queue_elements();
			elements[i].vertex = i;
			elements[i].distance = dest[i];
			pq.offer(elements[i]);
		}
		
		while(!pq.isEmpty()){
			Queue_elements e = pq.poll();
			int u = e.vertex;
			int u_dist = e.distance;
			Iterator<Edge> it = adj[u].listIterator();
			while(it.hasNext()){
				Edge ee = it.next();
				int v = ee.adjacentNode;
				int w = ee.weight;

				if(dest[v] > u_dist + w){
					dest[v] =  u_dist + w;
					pq.remove(elements[v]);
					Queue_elements newElement = new Queue_elements();
					newElement.vertex = v;
					newElement.distance = dest[v];
					elements[v] = newElement;
					pq.offer(newElement);
				}
			}

		}

		printCosts(dest);
	}

	public static void main(String[] args){
		Dijkstras s = new Dijkstras(9);
		s.addEdge(0, 1, 4);
		s.addEdge(0, 7, 8);
		s.addEdge(1, 2, 8);
		s.addEdge(1, 7, 11);
		s.addEdge(2, 3, 7);
		s.addEdge(2, 8, 2);
		s.addEdge(2, 5, 4);
		s.addEdge(3, 4, 9);
		s.addEdge(3, 5, 14);
		s.addEdge(4, 5, 10);
		s.addEdge(5, 6, 2);
		s.addEdge(6, 7, 1);
		s.addEdge(6, 8, 6);
		s.addEdge(7, 8, 7);

		s.calculateShortestPath();



	}


}
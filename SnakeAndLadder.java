import java.io.*;
import java.util.*;

class SnakeAndLadder{

static int numberOfMoves(Integer[] moves, int n){
	Integer[] parent = new Integer[n];
	for(int i=0; i<n; i++)
		parent[i] = -1;
	parent[0] =0;
	Queue<Integer> queue = new LinkedList<Integer>();
	queue.offer(0);
	int count =0;
	while(!queue.isEmpty()){
	
		int size = queue.size();
		while(size-- > 0){
			int pop_number = queue.poll();
			if(pop_number == n-1) 	return count;
			System.out.println(pop_number + " was popped");
			for(int i= pop_number +1; ((i < pop_number + 7) && i<n); i++){
				if(parent[i] == -1){
					int push_number = 0;
					if(moves[i] == -1) {
						push_number = i;
						parent[i] 			= pop_number;
					}		
					else {
						push_number = moves[i];
						parent[moves[i]] 	= pop_number;
						parent[i] = pop_number;
					}
					System.out.println(push_number + " was pushed");
					queue.offer(push_number);

				}
			}
		}
		
		count ++;
	}
	return count;
}	



public static void main(String[] args){
	int N = 30;
	Integer[] moves = new Integer[N];

	for(int i =0; i< N; i++)
		moves[i] = -1;

	//Ladders
	moves[2] = 21;
    moves[4] = 7;
    moves[10] = 25;
    moves[19] = 28;

	//Snakes
    moves[26] = 0;
    moves[20] = 8;
    moves[16] = 3;
   	moves[18] = 6;

   	System.out.println("The minimum number of moves required to reach BOX 30 is: " + numberOfMoves(moves, N));

}

}
import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;


class PriorityQueue_Test{

static class Queue_Element{
	int property;
} 

public static void main(String[] args) {
	Queue_Element[] elements = new Queue_Element[3];

	for(int i=0; i<3; i++)
		elements[i] = new Queue_Element();

	elements[0].property = 4;
	elements[1].property = 1;
	elements[2].property = 8;

	PriorityQueue<Queue_Element> pq = new PriorityQueue<Queue_Element>( 10, new Comparator<Queue_Element>() {

			public int compare(Queue_Element o1, Queue_Element o2) {
				return o1.property - o2.property;
			}
		});

	pq.offer(elements[0]);
	pq.offer(elements[1]);
	pq.offer(elements[1]);

	


}


}
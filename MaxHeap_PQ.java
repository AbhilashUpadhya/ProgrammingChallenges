import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeap_PQ {

	PriorityQueue<Integer> pq;

	public MaxHeap_PQ() {
		pq = new PriorityQueue<Integer>(10, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
	}

	public void insert(int[] x) {
		for (int i = 0; i < x.length; i++) {
			pq.offer(x[i]);
		}
	}

	public int extractMax() {
		return pq.poll();
	}

	public void display() {
		System.out.println(pq);
	}

	public int getSize() {
		return pq.size();
	}

	public void print() {
		System.out.println(pq);
	}

	public static void main(String[] args) {
		int[] arrA = { 1, 6, 2, 9, 4, 3, 8 };
		MaxHeap_PQ i = new MaxHeap_PQ();
		i.insert(arrA);
		i.print();
		System.out.println("Max Element in the Priority Queue: "
				+ i.extractMax());
		System.out.println("Max Element in the Priority Queue: "
				+ i.extractMax());
		System.out.println("Max Element in the Priority Queue: "
				+ i.extractMax());
		System.out.println("Priority Queue Size: " + i.getSize());
	}
} 
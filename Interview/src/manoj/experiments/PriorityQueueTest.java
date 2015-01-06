package manoj.experiments;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String args[]) {
		PriorityQueue q = new PriorityQueue();

		q.add(12345);
		q.add(2123);
		q.add(12);
		q.add(1242351235);
		q.add(1);
		
		System.out.println(q.peek());
		System.out.println(q.toString());
	}

}

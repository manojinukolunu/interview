package cracking.the.coding.interview.chapter2;

public class Prob21 {
	public static void main(String args[]) {
		LinkedListNode head = LinkedListNode.buildRandomList(15);
		while (head.next != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
}

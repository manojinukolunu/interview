package cracking.the.coding.interview.chapter2;

import java.util.Random;

public class LinkedListNode {
	LinkedListNode next = null;
	int data;

	public LinkedListNode(int _data) {
		data = _data;
	}
	void appendToTail(int _data) {
		LinkedListNode end = new LinkedListNode(_data);
		end.data = _data;
		LinkedListNode n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	LinkedListNode deleteNode(LinkedListNode head, int _data) {
		LinkedListNode n = head;
		if (n.data == _data) {
			return head.next;
		}
		while (n.next != null) {
			if (n.next.data == _data) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}

	public static LinkedListNode buildRandomList(int size) {
		Random r = new Random();
		LinkedListNode head = new LinkedListNode(1);
		for (int i = 1; i <= size; i++) {
			head.appendToTail(i + 1);
		}
		return head;
	}

	public void printList(LinkedListNode head) {
		while (head.next != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
}

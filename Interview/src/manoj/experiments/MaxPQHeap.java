package manoj.experiments;

import java.util.PriorityQueue;


public class MaxPQHeap<Key extends Comparable<Key>> {

	private Key[] pq; // heap-ordered complete binary tree
	private int size = 0; // in pq[1..size] with pq[0] unused

	public MaxPQHeap(int maxN) {
		pq = (Key[]) new Comparable[maxN + 1];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void insert(Key v) {
		pq[++size] = v;
		swim(size);
	}

	public Key delMax() {
		Key max = pq[1];
		exch(1, size--);
		pq[size + 1] = null;
		sink(1);
		return max;
	}
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
	private void exch(int i, int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k / 2, k);
			k = k / 2;
		}
	}

	private void sink(int k) {
		while (2 * k <= size) {
			int j = 2 * k;
			if (j < size && less(j, j + 1))
				j++;
			if (!less(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}
}

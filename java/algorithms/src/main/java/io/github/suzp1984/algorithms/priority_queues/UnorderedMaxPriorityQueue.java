package io.github.suzp1984.algorithms.priority_queues;

public class UnorderedMaxPriorityQueue<Key extends Comparable<Key>> {

	private Key[] pq;
	private int N;
	
	public UnorderedMaxPriorityQueue(int capacity) {
		pq = (Key[]) new Comparable[capacity];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void insert(Key k) {
		if (N >= pq.length) {
			delMax();
		}
		
		pq[N++] = k;
	}
	
	public Key delMax() {
		int max = 0;
		for (int i = 1; i < N; i++) {
			if (less(max, i)) {
				max = i;
			}
		}
		
		exch(max, N-1);
		
		return pq[--N];
	}
	
	private boolean less(int i, int j) {
		assert(i < N && j < N);
		
		Key ki = pq[i];
		Key kj = pq[j];
		
		return ki.compareTo(kj) < 0;
	}
	
	private void exch(int i, int j) {
		if (i == j) {
			return;
		}
		
		Key tmp = pq[i];
		pq[i] = pq[j];
		pq[j] = tmp;
	}
	
}

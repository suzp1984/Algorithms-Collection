package io.github.suzp1984.algorithms.priority_queues;

public class BinaryHeapsMaxPriorityQueue<Key extends Comparable<Key>> {

	private Key[] pq;
	private int N = 0;
	
	public BinaryHeapsMaxPriorityQueue(int capacity) {
		pq = (Key[]) new Comparable[capacity + 1];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void insert(Key x) {
		if (N >= (pq.length -1)) {
			pq[N] = x;
		} else {
			pq[++N] = x;
		}
		
		swim(N);
	}
	
	public Key delMax() {
		if (N == 0) {
			return null;
		}
		
		Key max = pq[1];
		exch(1, N--);
		sink(1);
		pq[N+1] = null;
		return max;
	}
	
	private void swim(int k) {
		while(k > 1 && less(k/2, k)) {
			exch(k, k/2);
			k = k/2;
		}
	}
	
	private void sink(int k) {
		while(2*k <= N) {
			int j = 2*k;
			if (j < N && less(j, j+1)) j++;
			if (!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	
	private boolean less(int i, int j) {
		assert(i <= N && j <= N);
		
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

package io.github.suzp1984.algorithms.stack;

public class FixedCapacityStack<K> {
	
	private K[] s;
	private int N = 0;
	
	@SuppressWarnings("unchecked")
	public FixedCapacityStack(int capacity) {
		K[] ks = (K[]) new Object[capacity];
		s = ks;
	}
	
	public boolean isEmpty() {
		return N == 0; 
	}
	
	public boolean isFull() {
		return N == (s.length - 1);
	}
	
	public void push(K item) {
		if (isFull()) {
			return;
		}
		
		s[N++] = item;
	}
	
	public K pop() {
		if (isEmpty()) {
			return null;
		}
		
		return s[--N];
	}
}

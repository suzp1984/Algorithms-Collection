package io.github.suzp1984.algorithms.sort;

public class HeapSort {

	public static void sort(Comparable[] a) {
		// first pass: Build Heap using bottom-up method.
		int N = a.length;
		
		for (int k = N/2; k >= 1; k--) {
			sink(a, k, N);
		}
		
		// second pass: sortdown
		while(N > 1) {
			exch(a, 1, N--);
			sink(a, 1, N);
		}
		
	}
	
	private static void sink(Comparable[] a, int k, int n) {
		
		while(2*k <= n) {
			int j = 2*k;
			if (j < n && less(a[j-1], a[j])) j++;
			if (!less(a[k-1], a[j-1])) break;
			exch(a, k, j);
			k = j;
		}
	}
	
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		assert(i <= a.length && j <= a.length);
		
		Comparable tmp = a[i-1];
		a[i-1] = a[j-1];
		a[j-1] = tmp;
	}
}

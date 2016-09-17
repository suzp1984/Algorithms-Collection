package io.github.suzp1984.algorithms.sort;

/**
 * Created by jacobsu on 9/17/16.
 */
public class SelectionSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
                exchage(a, i, min);
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    private static void exchage(Comparable[] a, int i, int j) {
        Comparable tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }
}

package io.github.suzp1984.algorithms.sort;

/**
 * Created by jacobsu on 9/17/16.
 */
public class InsertionSort {
    public static void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 0; i < N - 1; i++) {

            for (int j = i + 1; j > 0; j--) {
                if (less(a[j-1], a[j])) {
                    Comparable tmp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = tmp;
                } else {
                    break;
                }
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}

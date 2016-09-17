package io.github.suzp1984.algorithms.sort;

/**
 * Created by jacobsu on 9/17/16.
 */
public class ShellSort {
    public static void sort(Comparable[] a) {
        int N = a.length;

        int h = 1;
        while (h < N/3) {
            h = 3*h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exchage(a, j, j-h);
                }
            }

            h = h/3;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    private static void exchage(Comparable[] a, int i, int j) {
        if (i == j) {
            return;
        }

        Comparable tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }
}

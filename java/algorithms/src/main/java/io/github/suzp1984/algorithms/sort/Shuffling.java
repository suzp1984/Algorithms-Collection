package io.github.suzp1984.algorithms.sort;

/**
 * Created by jacobsu on 9/17/16.
 */
public class Shuffling {

    public static void shuffle(Object[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++) {
            int r = generateRandomInRange(0, i);
            exchage(a, i, r);
        }
    }

    private static void exchage(Object[] a, int i, int j) {
        if (i == j) {
            return;
        }

        Object tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }

    private static int generateRandomInRange(int min, int max) {
        int range = max - min + 1;

        return min + (int)(Math.random() * range);
    }
}

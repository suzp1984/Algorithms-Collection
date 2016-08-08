package io.github.suzp1984.algorithms;

/**
 * Created by jacobsu on 8/8/16.
 */
public class Euclid {
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }
}

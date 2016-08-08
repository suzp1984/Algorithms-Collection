package io.github.suzp1984.algorithms;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by jacobsu on 8/8/16.
 */
public class EuclidTest {
    @Test
    public void testGcd() {
        assertEquals(2, Euclid.gcd(10, 8));
        assertEquals(1, Euclid.gcd(5, 4));
    }
}

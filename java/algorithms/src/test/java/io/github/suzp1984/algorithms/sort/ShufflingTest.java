package io.github.suzp1984.algorithms.sort;

import org.junit.Test;

/**
 * Created by jacobsu on 9/17/16.
 */
public class ShufflingTest {

    @Test
    public void testShuffle() {
        Person[] ps = {new Person(1), new Person(9), new Person(5), new Person(8)};

        Shuffling.shuffle(ps);

        System.out.println(ps[0].getAge());
        System.out.println(ps[1].getAge());
        System.out.println(ps[2].getAge());
        System.out.println(ps[3].getAge());
    }
}

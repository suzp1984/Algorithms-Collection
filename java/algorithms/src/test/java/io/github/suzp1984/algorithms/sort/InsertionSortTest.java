package io.github.suzp1984.algorithms.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jacobsu on 9/17/16.
 */
public class InsertionSortTest {

    @Test
    public void testPersonInsertionSort() {
        Person[] ps = {new Person(1), new Person(9), new Person(5), new Person(8)};

        InsertionSort.sort(ps);

        Assert.assertEquals(9, ps[0].getAge());
        Assert.assertEquals(8, ps[1].getAge());
        Assert.assertEquals(5, ps[2].getAge());
        Assert.assertEquals(1, ps[3].getAge());
    }
}

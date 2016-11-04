package io.github.suzp1984.algorithms.sort;

import org.junit.Assert;
import org.junit.Test;

public class HeapSortTest {

	@Test
	public void testHeapSort() {
		 Person[] ps = {new Person(1), new Person(9), new Person(5), new Person(8)};

	        HeapSort.sort(ps);

	        Assert.assertEquals(1, ps[0].getAge());
	        Assert.assertEquals(5, ps[1].getAge());
	        Assert.assertEquals(8, ps[2].getAge());
	        Assert.assertEquals(9, ps[3].getAge());
	}
}

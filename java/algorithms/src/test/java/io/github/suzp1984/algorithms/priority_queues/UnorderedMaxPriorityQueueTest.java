package io.github.suzp1984.algorithms.priority_queues;

import org.junit.Assert;
import org.junit.Test;

public class UnorderedMaxPriorityQueueTest {

	@Test
	public void testMaxPQ() {
		UnorderedMaxPriorityQueue<Integer> mpq = new UnorderedMaxPriorityQueue<>(10);
		
		mpq.insert(10);
		mpq.insert(1);
		mpq.insert(18);
		mpq.insert(6);
		
		Assert.assertEquals(false, mpq.isEmpty());
		Assert.assertEquals(true, mpq.delMax() == 18);
	}
}

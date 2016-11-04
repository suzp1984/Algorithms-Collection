package io.github.suzp1984.algorithms.priority_queues;

import org.junit.Assert;
import org.junit.Test;

public class BinaryHeapsMaxPriorityQueueTest {

	@Test
	public void testBinaryHeap() {
		BinaryHeapsMaxPriorityQueue<Integer> bh = new BinaryHeapsMaxPriorityQueue<>(10);
		
		bh.insert(5);
		bh.insert(10);
		bh.insert(8);
		bh.insert(1);
		
		Assert.assertEquals(true, bh.delMax() == 10);
		
	}
}

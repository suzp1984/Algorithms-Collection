package io.github.suzp1984.algorithms.stack;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class StackTest {

	@Test
	public void testStandardStack() {
		Stack<String> s1 = new Stack<>();
		s1.push("a");
		Assert.assertTrue("a".equals(s1.pop()));
	}
	
	@Test
	public void testFixedCapacityStack() {
		FixedCapacityStack<String> fixedStack = new FixedCapacityStack<String>(10);
		
		fixedStack.push("a");
		fixedStack.push("b");
		fixedStack.push("c");
		
		Assert.assertTrue("c".equals(fixedStack.pop()));
		Assert.assertTrue("b".equals(fixedStack.pop()));
		Assert.assertTrue("a".equals(fixedStack.pop()));
		
	}
}

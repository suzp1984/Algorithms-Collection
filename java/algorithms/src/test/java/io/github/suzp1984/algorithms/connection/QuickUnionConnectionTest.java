package io.github.suzp1984.algorithms.connection;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.github.suzp1984.algorithms.connection.QuickUnionConnection;

public class QuickUnionConnectionTest {
	 @Test
	 public void testInt() {
		 QuickUnionConnection<Integer> intQU = new QuickUnionConnection<>();
		 
		 for (int i = 0; i < 10; i++) {
			 intQU.add(i);
		 }
		 
		 intQU.union(2, 3);
		 intQU.union(3, 4);
		 intQU.union(2, 7);
		 
		 assertEquals(true, intQU.isConnected(4, 7));
	 }
}

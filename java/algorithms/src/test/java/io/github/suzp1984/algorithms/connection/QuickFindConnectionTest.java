package io.github.suzp1984.algorithms.connection;

import org.junit.Test;

import io.github.suzp1984.algorithms.connection.QuickFindConnection;

import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

public class QuickFindConnectionTest {

	 @Test
	 public void testInt() {
		 QuickFindConnection<Integer> intQF = new QuickFindConnection<>();
		 
		 for (int i = 0; i < 10; i++) {
			 intQF.add(i);
		 }
		 
		 intQF.union(2, 3);
		 intQF.union(3, 4);
		 intQF.union(2, 7);
		 
		 assertEquals(true, intQF.isConnected(4, 7));
	 }
}

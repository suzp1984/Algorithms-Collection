package io.github.suzp1984.algorithms.queue;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created by jacobsu on 9/17/16.
 */
public class CustomeQueueTest {
    @Test
    public void testStringQueue() {
        CustomeQueue<String> qS = new CustomeQueue<>();

        Optional<String> r1 = qS.poll();
        Assert.assertTrue(!r1.isPresent());

        qS.add("a");
        qS.add("b");
        qS.add("c");

        r1 = qS.poll();
        Assert.assertTrue(r1.isPresent());
        Assert.assertTrue(r1.get().equals("a"));
        r1.ifPresent((s) -> {
                    Assert.assertTrue(s.equals("a"));
                }
        );

        r1 = qS.poll();
        Assert.assertTrue(r1.isPresent());
        Assert.assertTrue(r1.get().equals("b"));
        r1.ifPresent((s) -> {
                    Assert.assertTrue(s.equals("b"));
                }
        );

        r1 = qS.poll();
        Assert.assertTrue(r1.isPresent());
        Assert.assertTrue(r1.get().equals("c"));
        r1.ifPresent((s) -> {
                    Assert.assertTrue(s.equals("c"));
                }
        );

        r1 = qS.poll();
        Assert.assertTrue(!r1.isPresent());
    }
}

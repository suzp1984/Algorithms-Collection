package io.github.suzp1984.algorithms.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by jacobsu on 9/17/16.
 */
public class CustomeQueue<T> {

    private List<T> mDataSet = new LinkedList<>();

    public CustomeQueue() {

    }

    public void add(T t) {
        mDataSet.add(t);
    }

    public Optional<T> poll() {
        if (mDataSet.size() > 0) {
            return Optional.of(mDataSet.remove(0));
        }

        return Optional.empty();
    }
}

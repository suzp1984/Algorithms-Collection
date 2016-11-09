package io.github.suzp1984.algorithms.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by jacobsu on 11/8/16.
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node root;

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.value;
            }
        }

        return null;
    }

    public void delete(Key key) {

    }

    public Iterable<Key> iterator() {
        Queue<Key> q = new LinkedBlockingQueue<Key>();
        inorder(root, q);
        return q;
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key, value);
        }

        int cmp = key.compareTo(x.key);

        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }

        return x;
    }

    private void inorder(Node x, Queue<Key> q) {
        if (x == null) return;
        inorder(x.left, q);
        q.add(x.key);
        inorder(x.right, q);
    }

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
}

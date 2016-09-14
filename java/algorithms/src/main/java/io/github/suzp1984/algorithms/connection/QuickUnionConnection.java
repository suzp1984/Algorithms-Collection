package io.github.suzp1984.algorithms.connection;

import java.util.LinkedList;
import java.util.List;

public class QuickUnionConnection<T> implements IDynamicConnection<T> {

	private final List<Item> mDataSets = new LinkedList<>();
	
	public void add(T t) {
		if (findItem(t) == null) {
			mDataSets.add(new Item<T>(t));
		}
	}
	
	@Override
	public void union(T a, T b) {
		// TODO Auto-generated method stub
		addItem(a);
		addItem(b);
		
		Item roota = getRoot(findItem(a));
		Item rootb = getRoot(findItem(b));
		
		if (roota == null) {
			roota = new Item(a);
			mDataSets.add(roota);
		}
		
		if (rootb == null) {
			rootb = new Item(b);
			mDataSets.add(rootb);
		}
		
		rootb.parent = roota;
	}

	@Override
	public boolean isConnected(T a, T b) {
		
		Item roota = getRoot(findItem(a));
		Item rootb = getRoot(findItem(b));
		
		if (roota != null && rootb != null && roota.equals(rootb)) {
			return true;
		}
		
		return false;
	}
	
	private void addItem(T t) {
		if (findItem(t) == null) {
			mDataSets.add(new Item<T>(t));
		}
	}
	
	private Item findItem(T t) {
		for (Item i : mDataSets) {
			if (i.t.equals(t)) {
				return i;
			}
		}
		
		return null;
	}

	private Item getRoot(Item t) {
		if ( t == null) {
			return null;
		}
		
		while (t.parent != null) {
			t = t.parent;
		}
		
		return t;
	}
	
	public static class Item<T> {
		T t;
		Item parent;
		
		public Item(T t) {
			this.t = t;
			parent = null;
		}
		
		public boolean isRoot() {
			return parent == null;
		}
		
		public Item parent() {
			return parent;
		}
	}
}

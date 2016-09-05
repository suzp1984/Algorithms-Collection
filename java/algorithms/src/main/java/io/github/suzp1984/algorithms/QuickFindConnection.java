package io.github.suzp1984.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QuickFindConnection<T> implements IDynamicConnection<T> {

	private final List<InnerItem> mDataSets = new ArrayList<>();
	
	public void add(T t) {
		if (findItem(t) == null) {
			mDataSets.add(new InnerItem<T>(t));
		}
	}
	
	public void union(T a, T b) {
		if (findItem(a) == null) {
			add(a);
		}
		
		if (findItem(b) == null) {
			add(b);
		}
		
		InnerItem<T> ia = findItem(a);
		InnerItem<T> ib = findItem(b);
		
		int tmpIndex = ib.index;
		ib.index = ia.index;
		
		for (InnerItem<T> i : mDataSets) {
			if (i.index == tmpIndex) {
				i.index = ia.index;
			}
		}
	}
	
	public boolean isConnected(T a, T b) {
		InnerItem<T> ia = findItem(a);
		InnerItem<T> ib = findItem(b);
		
		if (ia == null || ib == null) {
			return false;
		}
		
		if (ia.index == ib.index) {
			return true;
		}
		
		return false;
	}
	
	private InnerItem<T> findItem(T t) {
		for (InnerItem<T> i : mDataSets) {
			if (i.item.equals(t)) {
				return i;
			}
		}
		
		return null;
	}
	
	public static class InnerItem<T> {
		T item;
		int index;
		
		public InnerItem(T t) {
			this.item = t;
			index = t.hashCode();
		}
	}
}

package io.github.suzp1984.algorithms.connection;

public interface IDynamicConnection<T> {

	public void union(T a, T b);
	
	public boolean isConnected(T a, T b);
}

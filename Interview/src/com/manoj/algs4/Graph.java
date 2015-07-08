package com.manoj.algs4;

public class Graph {
	
	private final int V;
	
	private Bag<Integer> [] adj;

	public Graph(int numVertices) {
		this.V = numVertices;
		adj = (Bag<Integer>[]) new Bag[numVertices];
		for(int v = 0;v<V;v++){
			adj[v] = new Bag<Integer>();
		}
	}

	public Graph(In in) {

	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	public int V() {
		return -1;
	}

	public int E() {
		return -1;
	}

	public String toString() {
		return null;
	}

}

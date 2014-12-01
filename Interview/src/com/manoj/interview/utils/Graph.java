package com.manoj.interview.utils;

public class Graph {

	public GraphNode buildRandomGraph() {
		GraphNode n = new GraphNode(1);
		GraphNode n1 = new GraphNode(2);
		n.addNodeToAdjacentList(n1);
		return n;
	}

	public static void main(String args[]) {
		Graph g = new Graph();

		GraphNode root = g.buildRandomGraph();

	}

}

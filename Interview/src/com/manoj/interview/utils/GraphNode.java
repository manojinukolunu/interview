package com.manoj.interview.utils;

import java.util.ArrayList;

public class GraphNode {

	public int data;
	public ArrayList<GraphNode> adjacentList;

	public void addNodeToAdjacentList(GraphNode n) {
		this.adjacentList.add(n);
	}

	public GraphNode(int _data) {
		this.data = _data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public ArrayList<GraphNode> getAdjacentList() {
		return adjacentList;
	}

	public void setAdjacentList(ArrayList<GraphNode> adjacentList) {
		this.adjacentList = adjacentList;
	}

}

package manoj.experiments;

import java.util.LinkedList;

public class Holder {
	TrieNode currentNode;
	private LinkedList<TrieNode> unvisitedNodes;

	public Holder() {
		unvisitedNodes = new LinkedList<TrieNode>();
	}

	public TrieNode getCurretNode() {
		return currentNode;
	}

	public LinkedList<TrieNode> getUnvisitedNodes() {
		return unvisitedNodes;
	}

	public void SetUnvisitedNodes(LinkedList<TrieNode> nodes) {
		unvisitedNodes = nodes;
	}

}

package manoj.experiments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class TrieNode {

	public char data;

	public HashMap<Character, TrieNode> linksMap;

	private boolean terminates = false;

	public TrieNode() {
		linksMap = new HashMap<Character, TrieNode>();
	}

	public TrieNode(char ch) {
		this();
		this.data = ch;
	}

	/**
	 * Iterative insert into the trie
	 * 
	 * @param key
	 */
	// Insert a given key into the trie
	public void addToTrie(String key) {
		HashMap<Character, TrieNode> tempLinks = linksMap;
		for (int i = 0; i < key.length(); i++) {
			Character ch = key.charAt(i);
			if (tempLinks.containsKey(ch)) {
<<<<<<< HEAD
				if (i == key.length() - 1) {
					tempLinks.get(ch).terminates = true;
				}
=======
>>>>>>> d6222f81990329a1e2247d998847720f85025f50
				tempLinks = tempLinks.get(ch).linksMap;
			} else {
				TrieNode newNode = new TrieNode(ch);
				tempLinks.put(ch, newNode);
				tempLinks = newNode.linksMap;
				if (i == key.length() - 1) {
					newNode.terminates = true;
				}
			}
		}
	}

	/**
	 * iterative trie print
	 * 
	 * @param root
	 */
	public static void printTrie(TrieNode root) {
		TrieNode temp;
		LinkedList<TrieNode> stack = new LinkedList<TrieNode>();
		stack.addFirst(root);
		while (!stack.isEmpty()) {
			temp = stack.getFirst();
			System.out
					.println(temp.data + " - - " + Arrays.asList(temp.linksMap)
							+ "  --  " + temp.terminates);

			HashMap<Character, TrieNode> tempLinks = temp.linksMap;
			for (Character t : tempLinks.keySet()) {
				stack.addLast(tempLinks.get(t));
			}
			stack.removeFirst();
		}
	}

	private static ArrayList<String> getKeysIterative(TrieNode node) {
		ArrayList<String> keys = new ArrayList<String>();
<<<<<<< HEAD
=======
		class Holder {
			private TrieNode currentNode;
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
>>>>>>> d6222f81990329a1e2247d998847720f85025f50

		Holder hold = new Holder();
		LinkedList<TrieNode> list = new LinkedList<TrieNode>();
		for (Character ch : node.linksMap.keySet()) {
			list.add(node.linksMap.get(ch));
		}
		hold.SetUnvisitedNodes(list);
		hold.currentNode = node;
		LinkedList<Holder> stack = new LinkedList<Holder>();
		stack.push(hold);

		while (stack.size() > 0) {
			Holder currentHolder = stack.getFirst();
			LinkedList<TrieNode> unvisited = currentHolder.getUnvisitedNodes();
			TrieNode currentNode = currentHolder.getCurretNode();
<<<<<<< HEAD
			if (currentNode.terminates && unvisited.size() == 0) {
				// add the contents of the stack to the list of strings and pop
				// the lastNode
				StringBuffer buff = new StringBuffer();
				// dont need the first element
				for (int k = 0; k < stack.size() - 1; k++) {
					Holder _hold = stack.get(k);
=======
			if (currentNode.terminates) {
				// add the contents of the stack to the list of strings and pop
				// the lastNode
				StringBuffer buff = new StringBuffer();
				for (Holder _hold : stack) {
>>>>>>> d6222f81990329a1e2247d998847720f85025f50
					buff.append(_hold.getCurretNode().data);
				}
				keys.add(buff.reverse().toString());
				if (unvisited.size() == 0) {
					stack.pop();
					continue;
				}
<<<<<<< HEAD

=======
>>>>>>> d6222f81990329a1e2247d998847720f85025f50
			}
			if (unvisited.size() > 0) {
				// get the first unvisited node and add it to the top of the
				// stack
				TrieNode visted = unvisited.removeFirst();
				Holder __hold = new Holder();
				LinkedList<TrieNode> _list = new LinkedList<TrieNode>();
				for (Character ch : visted.linksMap.keySet()) {
					_list.add(visted.linksMap.get(ch));
				}
				__hold.currentNode = visted;
				__hold.SetUnvisitedNodes(_list);
				stack.push(__hold);
			} else {
				stack.pop();
			}
		}
		return keys;
	}

<<<<<<< HEAD
	private static void printStack(LinkedList<Holder> stack) {
		for (Holder h : stack) {
			System.out.print(h.currentNode.data + " ");
		}
	}

=======
>>>>>>> d6222f81990329a1e2247d998847720f85025f50
	public static ArrayList<String> getStartingWith(TrieNode root, String start) {
		TrieNode currNode = null;
		currNode = root;
		StringBuffer buff = new StringBuffer();
		ArrayList<String> strings = new ArrayList<String>();
		for (int i = 0; i < start.length(); i++) {
			Character ch = start.charAt(i);
			if (currNode.terminates) {
				strings.add(buff.toString());
			}
			if (currNode.linksMap.containsKey(ch)) {
				buff.append(ch);
				currNode = currNode.linksMap.get(ch);
			} else {
				return null;
			}
		}
		ArrayList<String> keys = getKeysIterative(currNode);
		for (int i = 0; i < keys.size(); i++) {
			keys.set(i, buff.toString() + keys.get(i));

<<<<<<< HEAD
		}
		return keys;
=======
		return getKeysIterative(currNode);
>>>>>>> d6222f81990329a1e2247d998847720f85025f50
	}

	public static void printKeysInTrie(TrieNode node) {
		if (node.linksMap.size() == 0) {
			return;
		}
		for (Character ch : node.linksMap.keySet()) {
			if (node.terminates) {
				System.out.println();
			}
			System.out.print(ch);
			printKeysInTrie(node.linksMap.get(ch));
		}

	}

	public static void main(String args[]) {
		TrieNode root = new TrieNode();// create a root trie

		root.addToTrie("He");
<<<<<<< HEAD
		root.addToTrie("Heston");
		root.addToTrie("H");
=======
>>>>>>> d6222f81990329a1e2247d998847720f85025f50
		root.addToTrie("Hello");
		root.addToTrie("Hell");
		root.addToTrie("Hellish");
		root.addToTrie("Heap");
		root.addToTrie("Heatle");
		root.addToTrie("Heating");
		root.addToTrie("HellRaiser");
		root.addToTrie("be");
		root.addToTrie("Heat");
		root.addToTrie("Testing");

		System.out.println("Trie Build Complete");

		// printTrie(root);
		System.out.println(Arrays.toString(getStartingWith(root, "He")
				.toArray()));
	}
}

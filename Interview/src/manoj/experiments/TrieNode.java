package manoj.experiments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class TrieNode {

	public char data;

	public HashMap<Character, TrieNode> links;

	private boolean terminates = false;

	public TrieNode() {
		links = new HashMap<Character, TrieNode>();
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
		HashMap<Character, TrieNode> tempLinks = links;
		for (int i = 0; i < key.length(); i++) {
			Character ch = key.charAt(i);
			if (tempLinks.containsKey(ch)) {
				tempLinks = tempLinks.get(ch).links;
			} else {
				TrieNode newNode = new TrieNode(ch);
				tempLinks.put(ch, newNode);
				tempLinks = newNode.links;
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
			System.out.println(temp.data + " - - " + Arrays.asList(temp.links)
					+ "  --  " + temp.terminates);

			HashMap<Character, TrieNode> tempLinks = temp.links;
			for (Character t : tempLinks.keySet()) {
				stack.addLast(tempLinks.get(t));
			}
			stack.removeFirst();
		}
	}

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
			if (currNode.links.containsKey(ch)) {
				buff.append(ch);
				currNode = currNode.links.get(ch);
			} else {
				return null;
			}
		}

		// // we have reached the end of the given string now traverse the
		// // remaining trie.
		// LinkedList<TrieNode> stack = new LinkedList<TrieNode>();
		// stack.addFirst(currNode);
		// TrieNode tempNode;
		// while (!stack.isEmpty()) {
		// tempNode = stack.getFirst();
		// if (tempNode.links.size() == 1) {
		// // only one link so use existing buffer
		// buff.append(tempNode.data);
		// if (tempNode.terminates) {
		// strings.add(buff.toString());
		// }
		// } else {
		// for (Character ch : tempNode.links.keySet()) {
		// StringBuffer tempbuff = new StringBuffer();
		// tempbuff.append(ch);
		// tempNode = tempNode.links.get(ch);
		// }
		// }
		//
		// }
		printKeysInTrie(currNode);

		return null;
	}

	public static void printKeysInTrie(TrieNode node) {
		if (node.links.size() == 0) {
			return;
		}
		for (Character ch : node.links.keySet()) {
			if(node.terminates){
				System.out.println();
			}
			System.out.print(ch);
			printKeysInTrie(node.links.get(ch));
		}
		
	}

	public static void main(String args[]) {
		TrieNode root = new TrieNode();// create a root trie

		root.addToTrie("Hello");
		root.addToTrie("Hell");
		root.addToTrie("HellRaiser");
		root.addToTrie("be");
		root.addToTrie("Testing");

		System.out.println("Trie Build Complete");

//		printTrie(root);
		getStartingWith(root, "He");
	}
}

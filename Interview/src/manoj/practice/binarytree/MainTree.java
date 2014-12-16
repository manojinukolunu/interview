package manoj.practice.binarytree;

import java.util.ArrayList;
import java.util.HashMap;

import com.manoj.interview.utils.BinaryTreeNode;

public class MainTree {

	public static HashMap<Character, Integer> generateInorderHash(String inOrder) {
		HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
		for (int i = 0; i < inOrder.length(); i++) {
			hash.put(inOrder.charAt(i), i);
		}
		return hash;
	}

	public static BinaryTreeNode<Character> reconstructTree(String preOrder,
			String inOrder, HashMap<Character, Integer> map) {

		if (preOrder.equals("") || inOrder.equals("")) {
			return null;
		}

		BinaryTreeNode<Character> root = new BinaryTreeNode<Character>();

		char data = preOrder.charAt(0);
		

		String leftInorder = inOrder.substring(0, inOrder.indexOf(data));

		String rightInorder = inOrder.substring(inOrder.indexOf(data)+1,
				inOrder.length());

		root.data = data;

		root.left = reconstructTree(preOrder.substring(1, preOrder.length()),
				leftInorder, map);

		root.right = reconstructTree(preOrder.substring(1, preOrder.length()),
				rightInorder, map);

		return root;

	}

	public static BinaryTreeNode<Character> genTree() {
		BinaryTreeNode<Character> root = new BinaryTreeNode<Character>();

		root.data = 'H';

		root.left = createNode('B');
		root.right = createNode('C');
		root.left.left = createNode('F');
		root.left.right = createNode('E');
		root.left.right.left = createNode('A');

		root.right = createNode('C');
		root.right.right = createNode('D');
		root.right.right.right = createNode('G');
		root.right.right.right.left = createNode('I');

		return root;
	}

	public static void printInorderWalk(BinaryTreeNode<Character> root) {
		if (root != null) {
			printInorderWalk(root.left);
			System.out.print(root.data);
			printInorderWalk(root.right);
		}
	}

	public static void printPreOrderWalk(BinaryTreeNode<Character> root) {
		if (root != null) {
			System.out.print(root.data);
			printPreOrderWalk(root.left);
			printPreOrderWalk(root.right);
		}

	}

	public static void printPostOrderWalk(BinaryTreeNode<Character> root) {
		if (root != null) {
			printPostOrderWalk(root.left);
			printPostOrderWalk(root.right);
			System.out.print(root.data);
		}

	}

	public static BinaryTreeNode<Character> createNode(Character ch) {
		BinaryTreeNode<Character> node = new BinaryTreeNode<Character>();

		node.data = ch;
		return node;
	}

	public static void main(String args[]) {

		String inOrder = "FBAEHCDIG";
		String preOrder = "HBFEACDGI";

		BinaryTreeNode<Character> root = genTree();

		printPreOrderWalk(root);
		System.out.println();
		printInorderWalk(root);
		System.out.println();

		BinaryTreeNode<Character> reconstructTreeBNode = reconstructTree(
				preOrder, inOrder, generateInorderHash(inOrder));

		printPreOrderWalk(reconstructTreeBNode);
		System.out.println();

		printInorderWalk(reconstructTreeBNode);

	}
}

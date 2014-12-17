package manoj.practice.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.manoj.interview.utils.BinaryTreeNode;

public class MainTree {

	public static int preIndex = 0;

	public static ArrayList<Character> nullPreOrderWalk = new ArrayList<Character>();

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

		char data = preOrder.charAt(preIndex++);

		String leftInorder = inOrder.substring(0, inOrder.indexOf(data));

		String rightInorder = inOrder.substring(inOrder.indexOf(data) + 1,
				inOrder.length());

		root.data = data;

		root.left = reconstructTree(preOrder, leftInorder, map);

		root.right = reconstructTree(preOrder, rightInorder, map);

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
			nullPreOrderWalk.add(root.data);
			printPreOrderWalk(root.left);
			printPreOrderWalk(root.right);
		} else
			nullPreOrderWalk.add((Character) null);

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

	public static BinaryTreeNode<Character> reconstruct(
			List<Character> nullPreOrder) {
		Character data = nullPreOrder.get(preIndex);
		if (data == null) {
			return null;
		}

		BinaryTreeNode<Character> node = new BinaryTreeNode<Character>();

		node.data = nullPreOrder.get(preIndex++);

		node.left = reconstruct(nullPreOrder);

		preIndex++;

		node.right = reconstruct(nullPreOrder);

		return node;
	}

	public static void testReconstructTree() {
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

	public static void testReconstruct() {

		BinaryTreeNode<Character> root = genTree();
		printPreOrderWalk(root);

		List<Character> preOrder = nullPreOrderWalk;

		BinaryTreeNode<Character> reconstructedTree = reconstruct(preOrder);

		nullPreOrderWalk.clear();
		System.out.println();
		printPreOrderWalk(reconstructedTree);
		
		System.out.println(nullPreOrderWalk.equals(preOrder));
	}

	public static void main(String args[]) {
		testReconstruct();
	}
}

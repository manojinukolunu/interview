package manoj.practice.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

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
			if ((root.left == null) && (root.right == null)) {
				// System.out.print(root.data);
			}
			printInorderWalk(root.right);
		}
	}

	public static void printPreOrderWalk(BinaryTreeNode<Character> root) {
		if (root != null) {
			System.out.print(root.data);
			nullPreOrderWalk.add(root.data);
			printPreOrderWalk(root.left);
			printPreOrderWalk(root.right);
		} else {
			nullPreOrderWalk.add((Character) null);
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

	public static BinaryTreeNode<Character> genTree2() {
		BinaryTreeNode<Character> node = new BinaryTreeNode<Character>();
		node.data = 'A';
		node.left = new BinaryTreeNode<Character>();
		node.left.data = 'B';
		node.left.left = new BinaryTreeNode<Character>();
		node.left.left.data = 'C';
		node.left.left.left = new BinaryTreeNode<Character>();
		node.left.left.left.data = 'D';
		node.left.left.right = new BinaryTreeNode<Character>();
		node.left.left.right.data = 'E';

		node.left.right = new BinaryTreeNode<Character>();
		node.left.right.data = 'F';
		node.left.right.right = new BinaryTreeNode<Character>();
		node.left.right.right.data = 'G';
		node.left.right.right.left = new BinaryTreeNode<Character>();
		node.left.right.right.left.data = 'H';

		// add right nodes

		node.right = new BinaryTreeNode<Character>();
		node.right.data = 'I';
		node.right.left = new BinaryTreeNode<Character>();
		node.right.left.data = 'J';
		node.right.right = new BinaryTreeNode<Character>();
		node.right.right.data = 'O';
		node.right.left.right = createNode('K');
		node.right.left.right.left = createNode('L');
		node.right.left.right.right = createNode('N');
		node.right.left.right.left.right = createNode('M');
		node.right.right.right = createNode('P');
		return node;
	}

	public static void printLeaves() {
		BinaryTreeNode<Character> root = genTree2();
		printInorderWalk(root);
	}

	public static void getPath(BinaryTreeNode<Character> node, Character ch) {
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		Set<Character> visited = new HashSet<Character>();

		stack.push(node);
		stack.push(node.left);

	}

	public static BinaryTreeNode<Character> getLCA(
			BinaryTreeNode<Character> root, BinaryTreeNode<Character> nodeA,
			BinaryTreeNode<Character> nodeB) {
		if (root == null) {
			return null;
		} else if (root.data == nodeA.data || root.data == nodeB.data) {
			return root;
		}

		BinaryTreeNode<Character> lLCA = getLCA(root.left, nodeA, nodeB);
		BinaryTreeNode<Character> rLCA = getLCA(root.right, nodeA, nodeB);

		if (lLCA != null && rLCA != null) {
			return root;
		}

		return lLCA == null ? rLCA : lLCA;
	}

	public static void getLCATest() {
		BinaryTreeNode<Character> root = genTree2();

		BinaryTreeNode<Character> l = createNode('G');
		BinaryTreeNode<Character> r = createNode('P');

		BinaryTreeNode<Character> lca = getLCA(root, l, r);

		System.out.println(lca.data);
	}

	public static void main(String args[]) {

	}
}

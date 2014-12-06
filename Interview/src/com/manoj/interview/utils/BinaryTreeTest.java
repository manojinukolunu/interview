package com.manoj.interview.utils;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeTest {

	public static BinaryTreeNoParentNode<String> generateStringTree() {
		BinaryTreeNoParentNode<String> bTreeRoot = new BinaryTreeNoParentNode<String>();
		bTreeRoot.data = "root";

		BinaryTreeNoParentNode<String> bTreeLeft = new BinaryTreeNoParentNode<String>();
		bTreeLeft.data = "left";

		BinaryTreeNoParentNode<String> bTreeRight = new BinaryTreeNoParentNode<String>();
		bTreeRight.data = "right";

		bTreeRoot.left = bTreeLeft;
		bTreeRoot.right = bTreeRight;

		return bTreeRoot;
	}

	public static BinaryTreeNoParentNode<Integer> generateIntegerTree() {
		BinaryTreeNoParentNode<Integer> bTreeRoot = new BinaryTreeNoParentNode<Integer>();
		bTreeRoot.data = 314;

		BinaryTreeNoParentNode<Integer> bTreeLeft = new BinaryTreeNoParentNode<Integer>();
		bTreeLeft.data = 6;

		BinaryTreeNoParentNode<Integer> bTreeRight = new BinaryTreeNoParentNode<Integer>();
		bTreeRight.data = 6;

		bTreeRoot.left = bTreeLeft;
		bTreeRoot.right = bTreeRight;
		BinaryTreeNoParentNode childNode = addNode(bTreeLeft, 2, "right");
		BinaryTreeNoParentNode childNode1 = addNode(bTreeRight, 2, "left");
		addNode(childNode, 3, "right");
		addNode(childNode1, 2, "left");
		return bTreeRoot;
	}
	private static BinaryTreeNoParentNode addNode(
			BinaryTreeNoParentNode<Integer> bTreeNode, int i, String string) {
		if (string.equals("left")) {
			BinaryTreeNoParentNode<Integer> node = new BinaryTreeNoParentNode<Integer>();
			node.data = i;
			bTreeNode.left = node;
			return node;
		} else if (string.equals("right")) {
			BinaryTreeNoParentNode<Integer> node = new BinaryTreeNoParentNode<Integer>();
			node.data = i;
			bTreeNode.right = node;
			return node;
		}
		return null;
	}

	public static ArrayList<ArrayList<BinaryTreeNoParentNode>> getListFromBinrayTree(
			BinaryTreeNoParentNode root) {
		LinkedList<BinaryTreeNoParentNode> queue = new LinkedList<BinaryTreeNoParentNode>();
		queue.add(root);
		ArrayList<ArrayList<BinaryTreeNoParentNode>> lists = new ArrayList<ArrayList<BinaryTreeNoParentNode>>();
		while (!queue.isEmpty()) {
			ArrayList<BinaryTreeNoParentNode> list = new ArrayList<BinaryTreeNoParentNode>();
			for (int i = 0; i < queue.size(); i++) {
				list.add(queue.get(i));
			}
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				BinaryTreeNoParentNode<String> node = queue.pop();

				if (node.left != null) {
					queue.addLast(node.left);
				}
				if (node.right != null) {
					queue.addLast(node.right);
				}
			}
			lists.add(list);
		}
		return lists;
	}
	public static void main(String args[]) {
		BinaryTreeNoParentNode root = generateIntegerTree();
		ArrayList<ArrayList<BinaryTreeNoParentNode>> lists = getListFromBinrayTree(root);

		for (int i = 0; i < lists.size(); i++) {
			ArrayList<BinaryTreeNoParentNode> list = lists.get(i);
			for (BinaryTreeNoParentNode node : list) {
				System.out.print(node.data + " ");
			}
			System.out.println();
		}
	}
}

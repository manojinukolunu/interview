package com.manoj.interview.utils;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeTest {

	public static BinaryTreeNode<String> generateStringTree() {
		BinaryTreeNode<String> bTreeRoot = new BinaryTreeNode<String>();
		bTreeRoot.data = "root";

		BinaryTreeNode<String> bTreeLeft = new BinaryTreeNode<String>();
		bTreeLeft.data = "left";

		BinaryTreeNode<String> bTreeRight = new BinaryTreeNode<String>();
		bTreeRight.data = "right";

		bTreeRoot.left = bTreeLeft;
		bTreeRoot.right = bTreeRight;

		return bTreeRoot;
	}

	public static BinaryTreeNode<Integer> generateIntegerTree() {
		BinaryTreeNode<Integer> bTreeRoot = new BinaryTreeNode<Integer>();
		bTreeRoot.data = 314;

		BinaryTreeNode<Integer> bTreeLeft = new BinaryTreeNode<Integer>();
		bTreeLeft.data = 6;

		BinaryTreeNode<Integer> bTreeRight = new BinaryTreeNode<Integer>();
		bTreeRight.data = 6;

		bTreeRoot.left = bTreeLeft;
		bTreeRoot.right = bTreeRight;
		BinaryTreeNode childNode = addNode(bTreeLeft, 2, "right");
		BinaryTreeNode childNode1 = addNode(bTreeRight, 2, "left");
		addNode(childNode, 3, "right");
		addNode(childNode1, 2, "left");
		return bTreeRoot;
	}
	private static BinaryTreeNode addNode(
			BinaryTreeNode<Integer> bTreeNode, int i, String string) {
		if (string.equals("left")) {
			BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>();
			node.data = i;
			bTreeNode.left = node;
			return node;
		} else if (string.equals("right")) {
			BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>();
			node.data = i;
			bTreeNode.right = node;
			return node;
		}
		return null;
	}

	public static ArrayList<ArrayList<BinaryTreeNode>> getListFromBinrayTree(
			BinaryTreeNode root) {
		LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);
		ArrayList<ArrayList<BinaryTreeNode>> lists = new ArrayList<ArrayList<BinaryTreeNode>>();
		while (!queue.isEmpty()) {
			ArrayList<BinaryTreeNode> list = new ArrayList<BinaryTreeNode>();
			for (int i = 0; i < queue.size(); i++) {
				list.add(queue.get(i));
			}
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				BinaryTreeNode<String> node = queue.pop();

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
		BinaryTreeNode root = generateIntegerTree();
		ArrayList<ArrayList<BinaryTreeNode>> lists = getListFromBinrayTree(root);

		for (int i = 0; i < lists.size(); i++) {
			ArrayList<BinaryTreeNode> list = lists.get(i);
			for (BinaryTreeNode node : list) {
				System.out.print(node.data + " ");
			}
			System.out.println();
		}
	}
}

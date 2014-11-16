package cracking.the.coding.interview.chapter4;

import java.util.ArrayList;
import java.util.Arrays;

public class Prob49 {

	public static final int givenSum = 49;

	public static void findSum(TreeNode node, int sum, int[] path, int level) {
		if (node == null) {
			return;
		}

		path[level] = node.data;
		int t = 0;
		for (int i = level; i >= 0; i--) {
			t += path[i];
			if (t == sum) {
				print(path, i, level);
			}
		}

		findSum(node.left, sum, path, level + 1);
		findSum(node.right, sum, path, level + 1);

		path[level] = Integer.MIN_VALUE;
	}

	public static void findSum(TreeNode node, int sum) {
		int depth = depth(node);
		int[] path = new int[depth];
		findSum(node, sum, path, 0);
	}

	public static void print(int[] path, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.println(path[i] + " ");
		}
		System.out.println();
	}

	public static int depth(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + Math.max(depth(node.left), depth(node.right));
		}
	}
	public static void checkSumUntil(TreeNode root, int sum,
			ArrayList<String> path) {
		if (root == null) {

			return;
		}
		sum += root.data;
		path.add(root.data + "");
		if (sum == givenSum) {
			System.out.println(Arrays.toString(path.toArray()));
		}
		checkSumUntil(root.left, sum, path);
		checkSumUntil(root.right, sum, path);
	}
	public static void main(String args[]) {
		TreeNode root = TreeNode.buildRandomTree();
		findSum(root, 25);
	}
}

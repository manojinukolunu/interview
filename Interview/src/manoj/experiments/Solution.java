package manoj.experiments;

import java.util.LinkedList;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {

	private static boolean isValidRow(char[] row) {
		int[] arr = new int[10];
		return true;
	}
	private static boolean isValidColumn(char[] column) {
		return false;
	}

	private static boolean isValidSubMatrix(char[][] sBoard) {
		return false;
	}

	public static boolean isValidSudoku(char[][] board) {
		return false;
	}

	private static boolean hasPathSumRecursive(TreeNode root, int sum) {
		if (root == null && sum == 0) {
			return true;
		} else if (root == null && sum != 0) {
			return false;
		}
		boolean hasLeftSum = hasPathSumRecursive(root.left, sum - root.val);
		boolean hasRightSum = hasPathSumRecursive(root.right, sum - root.val);
		if (hasLeftSum || hasRightSum) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		} else {
			return hasPathSumRecursive(root, sum);
		}
	}

	public static boolean isValid(String s) {
		if (s.length() % 2 != 0)
			return false;
		LinkedList stack = new LinkedList();
		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			if (!stack.isEmpty()) {
				char prevChar = (char) stack.peek();
				switch (currentChar) {
					case ')' :
						if (prevChar != '(') {
							return false;
						} else if (prevChar == '(') {
							stack.pop();
						}
						break;
					case ']' :
						if (prevChar != '[')
							return false;
						else if (prevChar == '[') {
							stack.pop();
						}
						break;
					case '}' :
						if (prevChar != '{')
							return false;
						else if (prevChar == '{') {
							stack.pop();
						}
						break;
				}
			}
			if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
				stack.push(currentChar);
			}
		}
		if (stack.isEmpty())
			return true;
		return false;
	}
	public static TreeNode constructTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		return root;
		// root.right = new TreeNode(8);
		// root.left.left = new TreeNode(11);
		// root.left.left.right = new TreeNode(2);
		// root.left.left.left = new TreeNode(7);
		//
		// root.right = new TreeNode(8);
		// root.right.left = new TreeNode(13);
		// root.right.right = new TreeNode(4);
		// root.right.right.right = new TreeNode(1);
		// return root;

	}

	public static void main(String args[]) {
		System.out.println(isValid("[])"));
	}
}
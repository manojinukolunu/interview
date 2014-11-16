package cracking.the.coding.interview.chapter4;

public class TreeNode {
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;

	public int data;

	public TreeNode(int data) {
		this.data = data;
	}

	public TreeNode search(TreeNode root, int _data) {
		if (root.data == _data) {
			return root;
		} else if (_data < root.data) {
			return search(root.left, _data);
		} else if (_data > root.data) {
			return search(root.right, _data);
		} else {
			return null;
		}
	}

	public void insert(int data) {
		TreeNode root = this;
		if (data <= root.data) {
			if (root.left == null) {
				root.left = new TreeNode(data);
			} else {
				root.left.insert(data);
			}
		} else {
			if (root.right == null) {
				root.right = new TreeNode(data);
			} else {
				root.right.insert(data);
			}
		}
	}

	public TreeNode findMinRecursive(TreeNode root) {
		if (root.left == null) {
			System.out.println();
			return root;

		} else {
			return findMinRecursive(root.left);
		}
	}

	public static void printTree(TreeNode root) {
		BTreePrinter.printNode(root);
	}
	public int getHeight() {
		int leftHeight = left != null ? left.getHeight() : 0;
		int rightHeight = right != null ? right.getHeight() : 0;
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public static TreeNode buildRandomTree() {
		TreeNode root = new TreeNode(10);
		root.insert(12);
		root.insert(13);
		root.insert(11);
		root.insert(8);
		root.insert(7);
		root.insert(9);
		root.insert(14);

		return root;
	}
	public static void main(String args[]) {
		TreeNode root = TreeNode.buildRandomTree();
		printTree(root);
		System.out.println(root.getHeight());
	}

}

package com.manoj.interview.utils;

public class BinaryTreeNode<T> {

	public BinaryTreeNode<T> left;
	public BinaryTreeNode<T> right;

	public T data;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		BinaryTreeNode that = (BinaryTreeNode) o;

		if (data != null ? !data.equals(that.data) : that.data != null) {
			return false;
		}
		if (left != null ? !left.equals(that.left) : that.left != null) {
			return false;
		}
		if (right != null ? !right.equals(that.right) : that.right != null) {
			return false;
		}

		return true;
	}

}

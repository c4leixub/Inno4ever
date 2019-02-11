package com.lkin.trees.topBottom;

import com.common.structs.TreeNode;

public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		invert(root);
		return root;
	}

	private void invert(TreeNode node) {
		if (node == null) {
			return;
		}

		TreeNode t = node.left;
		node.left = node.right;
		node.right = t;

		invertTree(node.right);
		invertTree(node.left);
	}
}

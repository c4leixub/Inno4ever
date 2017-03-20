package com.zeetcode.tree;

public class TreeHeight {

	public int treeHeight(Node root) {
		if (root == null) {
			return 0;
		}
		
		int leftHeight = treeHeight(root.left);
		int rightHeight = treeHeight(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}
}

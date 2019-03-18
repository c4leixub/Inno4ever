package com.lkin.trees.topBottom;

import com.common.structs.TreeNode;

public class ValidBST {
	public boolean isValidBST(TreeNode root) {
		long min = Integer.MIN_VALUE - 1L;
		long max = Integer.MAX_VALUE + 1L;
		return isValidBST(root, min, max);
	}

	private boolean isValidBST(TreeNode node, long min, long max) {
		if (node == null) {
			return true;
		}

		if (min < node.val && node.val < max) {
			return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
		}

		return false;
	}
}

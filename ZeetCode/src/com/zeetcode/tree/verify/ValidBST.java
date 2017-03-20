package com.zeetcode.tree.verify;

import com.zeetcode.node.TreeNode;

public class ValidBST {
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean isValidBST(TreeNode p, double min, double max) {
		if (p == null)
			return true;

		if (p.val <= min || p.val >= max)
			return false;

		return isValidBST(p.left, min, p.val)
				&& isValidBST(p.right, p.val, max);
	}
}

package com.zeetcode.aalk.tree;

import com.zeetcode.node.TreeNode;

public class MaxDepthTree {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
}

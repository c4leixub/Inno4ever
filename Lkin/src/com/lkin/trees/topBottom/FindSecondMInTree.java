package com.lkin.trees.topBottom;

import com.common.structs.TreeNode;

public class FindSecondMInTree {
	public int findSecondMinimumValue(TreeNode root) {
		if (root == null) {
			return -1;
		}

		long[] min = new long[] { Long.MAX_VALUE - 1, Long.MAX_VALUE };
		dfs(root, min);

		if (min[0] < min[1] && min[1] < Long.MAX_VALUE - 1) {
			return (int) min[1];
		}

		return -1;
	}

	private void dfs(TreeNode node, long[] min) {
		if (node == null) {
			return;
		}

		if (node.val < min[0]) {
			long t = min[0];
			min[0] = node.val;
			min[1] = t;
		} else if (min[0] < node.val && node.val < min[1]) {
			min[1] = node.val;
		}

		dfs(node.left, min);
		dfs(node.right, min);
	}
}

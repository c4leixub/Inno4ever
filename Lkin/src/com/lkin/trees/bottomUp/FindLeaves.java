package com.lkin.trees.bottomUp;

import java.util.ArrayList;
import java.util.List;

import com.common.structs.TreeNode;

public class FindLeaves {
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		dfs(result, root);
		return result;
	}

	private int dfs(List<List<Integer>> result, TreeNode node) {
		if (node == null) {
			return -1;
		}

		int left = dfs(result, node.left);
		int right = dfs(result, node.right);
		int cur = Math.max(left, right) + 1;

		if (result.size() <= cur) {
			result.add(new ArrayList<Integer>());
		}
		result.get(cur).add(node.val);

		return cur;
	}
}

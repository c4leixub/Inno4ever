package com.lkin.trees.topBottom;

import java.util.ArrayList;
import java.util.List;

import com.common.structs.TreeNode;

/* Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum. */
public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null) {
			return sum - root.val == 0;
		}

		if (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val)) {
			return true;
		}

		return false;
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		dfs(result, new ArrayList<Integer>(), sum, root);
		return result;
	}

	private void dfs(List<List<Integer>> result, List<Integer> list, int sum, TreeNode node) {
		if (node.left == null && node.right == null) {
			if (sum - node.val == 0) {
				result.add(new ArrayList<>(list));
				result.get(result.size() - 1).add(node.val);
			}
			return;
		}

		list.add(node.val);

		if (node.left != null) {
			dfs(result, list, sum - node.val, node.left);
		}
		if (node.right != null) {
			dfs(result, list, sum - node.val, node.right);
		}

		list.remove(list.size() - 1);
	}
}

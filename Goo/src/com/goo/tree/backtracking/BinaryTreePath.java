package com.goo.tree.backtracking;

import java.util.ArrayList;
import java.util.List;

import com.goo.node.TreeNode;


/**
 * Given a binary tree, return all root-to-leaf paths. For example, given the
 * following binary tree:
 * 
 * 1 / \ 2 3 \ 5 All root-to-leaf paths are: ["1->2->5", "1->3"]
 */
public class BinaryTreePath {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		if (root == null) {
			return result;
		}

		binaryTreePaths(root, result, new ArrayList<Integer>());
		return result;
	}

	public void binaryTreePaths(TreeNode node, List<String> result,
			List<Integer> values) {
		if (node.left == null && node.right == null) {
			values.add(node.val);
			
			StringBuilder sb = new StringBuilder();
            for (int i = 0; i < values.size() - 1; i++) {
                sb.append(values.get(i));
                sb.append("->");
            }
            sb.append(values.get(values.size()-1));
			
			return;
		}

		values.add(node.val);
		if (node.left != null) {
			binaryTreePaths(node.left, result, values);
			values.remove(values.size() - 1);
		}

		if (node.right != null) {
			binaryTreePaths(node.right, result, values);
			values.remove(values.size() - 1);
		}

	}

	public void addPathToResult(List<String> result, List<Integer> values) {
		StringBuilder sb = new StringBuilder();
		sb.append(values.get(0));
		for (int i = 1; i < values.size(); i++) {
			sb.append("->");
			sb.append(values.get(i));
		}
		result.add(sb.toString());
	}
}

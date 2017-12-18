package com.zeetcode.aalk.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.zeetcode.node.TreeNode;

public class LevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (root == null) {
			return result;
		}

		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		q1.add(root);

		while (!q1.isEmpty()) {

			traverseHelper(q1, q2, result);

			if (q2.isEmpty())
				break;

			traverseHelper(q2, q1, result);
		}

		return result;
	}

	private void traverseHelper(Queue<TreeNode> q1, Queue<TreeNode> q2, List<List<Integer>> result) {
		List<Integer> list = new ArrayList<Integer>();
		TreeNode node;
		while (!q1.isEmpty()) {
			node = q1.poll();
			list.add(node.val);
			if (node.left != null) {
				q2.add(node.left);
			}

			if (node.right != null) {
				q2.add(node.right);
			}
		}
		result.add(list);
	}
}

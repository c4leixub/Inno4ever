package com.lkin.tree.level;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.common.structs.TreeNode;

public class LevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}

		Queue<TreeNode> cur = new LinkedList<TreeNode>();
		Queue<TreeNode> next = new LinkedList<TreeNode>();
		Queue<TreeNode> t;

		TreeNode node;
		cur.add(root);
		while (!cur.isEmpty()) {

			List<Integer> list = new ArrayList<Integer>();
			while (!cur.isEmpty()) {
				node = cur.poll();
				list.add(node.val);

				if (node.left != null) {
					next.add(node.left);
				}
				if (node.right != null) {
					next.add(node.right);
				}
			}

			result.add(list);
			t = cur;
			cur = next;
			next = t;
		}

		return result;
	}
}

package com.lkin.tree.level;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.common.structs.TreeNode;

public class LargeValueInEachLevel {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}

		Queue<TreeNode> cur = new LinkedList<TreeNode>();
		Queue<TreeNode> next = new LinkedList<TreeNode>();
		Queue<TreeNode> t;

		TreeNode node;
		cur.add(root);
		while (!cur.isEmpty()) {

			int max = Integer.MIN_VALUE;
			while (!cur.isEmpty()) {
				node = cur.poll();
				max = Math.max(max, node.val);

				if (node.left != null) {
					next.add(node.left);
				}
				if (node.right != null) {
					next.add(node.right);
				}
			}

			result.add(max);
			t = cur;
			cur = next;
			next = t;
		}

		return result;
	}
}

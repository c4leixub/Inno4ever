package com.zeetcode.tree.traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.zeetcode.node.TreeNode;

public class VerticalOrderTraversal {
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}

		Map<Integer, List<Integer>> colToVals = new HashMap<Integer, List<Integer>>();
		int min = 0, max = 0;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> colQueue = new LinkedList<Integer>();
		queue.add(root);
		colQueue.add(0);

		int col;
		TreeNode node;
		while (!queue.isEmpty() && !colQueue.isEmpty()) {
			node = queue.poll();
			col = colQueue.poll();

			if (!colToVals.containsKey(col)) {
				colToVals.put(col, new ArrayList<Integer>());
			}
			colToVals.get(col).add(node.val);
			min = Math.min(min, col);
			max = Math.max(max, col);

			if (node.left != null) {
				queue.add(node.left);
				colQueue.add(col - 1);
			}

			if (node.right != null) {
				queue.add(node.right);
				colQueue.add(col + 1);
			}
		}

		for (int k = min; k <= max; k++) {
			result.add(colToVals.get(k));
		}

		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		VerticalOrderTraversal t = new VerticalOrderTraversal();
		System.out.println(t.verticalOrder(root));

	}
}

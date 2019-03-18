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

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		int size, max;
		TreeNode node;
		while (!queue.isEmpty()) {
			size = queue.size();
			max = Integer.MIN_VALUE;
			while (size > 0) {
				node = queue.poll();
				max = Math.max(max, node.val);

				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				
				size--;
			}

			result.add(max);
		}

		return result;
	}
}

package com.goo.tree.levelorder;

import java.util.LinkedList;
import java.util.Queue;

import com.goo.node.TreeNode;

/**
 * 1161. https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 * @author xlei
 */
public class MaxLevelSum {
	public int maxLevelSum(TreeNode root) {

		int maxLevel = -1, maxSum = Integer.MIN_VALUE, curLevel = 1;
		TreeNode node;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			int k = q.size(), sum = 0;
			while (k > 0) {
				node = q.poll();
				sum += node.val;

				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
				k--;
			}

			if (sum > maxSum) {
				maxSum = sum;
				maxLevel = curLevel;
			}
			curLevel++;
		}

		return maxLevel;
	}
}

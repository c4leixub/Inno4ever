package com.goo.tree.levelorder;

import java.util.LinkedList;
import java.util.Queue;

import com.goo.node.TreeNode;

/**
 * 1602. https://leetcode.com/problems/find-nearest-right-node-in-binary-tree/
 * @author xlei
 *
 */
public class FindNearestRightNode {

	public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		TreeNode node;
		while (!q.isEmpty()) {
			int k = q.size();
			while (k > 0) {
				node = q.poll();
				k--;

				if (node == u) {
					if (k == 0) {
						return null;
					} else {
						return q.poll();
					}
				}

				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
		}

		return null;
	}
}

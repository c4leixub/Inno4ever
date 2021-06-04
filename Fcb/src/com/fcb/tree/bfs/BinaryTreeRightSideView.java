package com.fcb.tree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.fcb.node.TreeNode;

public class BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);

		TreeNode node;
		int k;
		while (!q.isEmpty()) {

			k = q.size();
			while (k > 0) {
				node = q.poll();

				if (node.left != null) {
					q.add(node.left);
				}

				if (node.right != null) {
					q.add(node.right);
				}

				if (k == 1) {	// we only care the last element at the level
					result.add(node.val);
				}

				k--;
			}
		}

		return result;

	}
}

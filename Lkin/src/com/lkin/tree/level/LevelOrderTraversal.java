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
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		int size;
		TreeNode node;
		List<Integer> list;
		while (!queue.isEmpty()) {
			size = queue.size();
			list = new ArrayList<Integer>();
			while (size > 0) {
				node = queue.poll();
				list.add(node.val);

				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				
				size--;
			}
			
			result.add(list);
		}

		return result;
	}
}

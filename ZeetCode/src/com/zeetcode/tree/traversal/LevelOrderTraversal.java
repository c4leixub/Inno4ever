package com.zeetcode.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.zeetcode.node.TreeNode;

public class LevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) return result;
		
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		q1.add(root);
		
		TreeNode e;
		List<Integer> list;
		while (!q1.isEmpty() || !q2.isEmpty()) {
			
			list = new ArrayList<Integer>();
			while (!q1.isEmpty()) {
				e = q1.poll();
				list.add(e.val);
				if (e.left != null) q2.add(e.left);
				if (e.right != null) q2.add(e.right);
			}
			result.add(list);
			
			if (q2.isEmpty()) break;
			list = new ArrayList<Integer>();
			while (!q2.isEmpty()) {
				e = q2.poll();
				list.add(e.val);
				if (e.left != null) q1.add(e.left);
				if (e.right != null) q1.add(e.right);
			}
			result.add(list);
		}
		
//		while (!q1.isEmpty()) {
//			traversalOneLevel(q1, q2, result);
//			if (q2.isEmpty()) break;
//			traversalOneLevel(q2, q1, result);
//		}
		
		return result;
    }
	
	public void traversalOneLevel(Queue<TreeNode> q1, Queue<TreeNode> q2, List<List<Integer>> result) {
		if (q1.isEmpty())	return;
		
		TreeNode e;
		List<Integer> list = new ArrayList<Integer>();
		while (!q1.isEmpty()) {
			e = q1.poll();
			list.add(e.val);
			if (e.left != null) q2.add(e.left);
			if (e.right != null) q2.add(e.right);
		}
		result.add(list);
	}
}

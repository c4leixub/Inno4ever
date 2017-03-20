package com.zeetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.zeetcode.node.TreeNode;

public class AverageByLevel {
	
	public double averageByLevel(TreeNode root, int i) {
		if (root == null || i < 1)	return 0.0;
		
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		
		q1.add(root);
		int level = 1;
		
		Queue<TreeNode> q = null;
		while (!q1.isEmpty() || !q2.isEmpty()) {
			
			if (level == i) { 
				q = q1;
				break;
			}
			while (!q1.isEmpty()) {
				q2.add(q1.poll());	
			}
			level++;
			
			if (level == i) { 
				q = q2;
				break;
			}
			while (!q2.isEmpty()) {
				q1.add(q2.poll());
			}
			level++;
		}
		
		if (q == null) return 0.0;
		double sum = 0.0;
		int size = q.size();
		if (level == i) {
			sum = sum + q.poll().val;
		}
		return sum / size;
	}
}

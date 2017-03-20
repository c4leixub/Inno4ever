package com.zeetcode.tree.dfs.stack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import com.zeetcode.node.TreeNode;

public class ClosestBSTValue {

	/**
	 * Given a non-empty binary search tree and a target value, find the value
	 * in the BST that is closest to the target.
	 */
	public int closestValue(TreeNode root, double target) {
		TreeNode result = null;
		double diff = Double.MAX_VALUE;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (p != null) {
			stack.push(p);
			p = p.left;
		}

		while (!stack.isEmpty()) {
			p = stack.pop();

			if (result == null || Math.abs(p.val - target) < diff) {
				result = p;
				diff = Math.abs(p.val - target);
			} else if (Math.abs(p.val - target) > diff) {
				break;	// 后面的数只会更大
			}

			p = p.right;
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
		}

		return result.val;
	}

	public List<Integer> closestKValues(TreeNode root, double target, int k) {

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			public int compare(Integer i, Integer j) {
                if (Math.abs(i-target) > Math.abs(j-target)) {
                    return -1;
                } else if (Math.abs(i-target) < Math.abs(j-target)) {
                    return 1;
                }
                
                return 0;
            }
		});

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (p != null) {
			stack.push(p);
			p = p.left;
		}

		while (!stack.isEmpty()) {
			p = stack.pop();

			if (queue.size() < k) {
				queue.add(p.val);
			} else {
				if (Math.abs(p.val - target) < Math.abs(queue.peek() - target)) {
					queue.poll();
					queue.add(p.val);
				} else {
					break;	// 后面的数只会更大
				}
			}

			p = p.right;
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
		}

		return new ArrayList<Integer>(queue);
	}
}

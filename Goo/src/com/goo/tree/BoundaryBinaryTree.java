package com.goo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.goo.node.TreeNode;

/**
 * 545 https://leetcode.com/problems/boundary-of-binary-tree/
 * @author xlei
 *
 */
public class BoundaryBinaryTree {
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		
		if (!isLeaf(root)) {
			res.add(root.val);
		}
		
		// left boundary
		TreeNode t = root.left;
		while (t != null) {
			if (!isLeaf(t)) {
				res.add(t.val);
			}
			if (t.left != null) {
				t = t.left;
			} else {
				t = t.right;
			}

		}

		// add all the leaves
		addLeaves(res, root);

		// right boundary
		Stack<Integer> s = new Stack<>();
		t = root.right;
		while (t != null) {
			if (!isLeaf(t)) {
				s.push(t.val);
			}
			
			if (t.right != null) {
				t = t.right;
			} else {
				t = t.left;
			}
		}
		while (!s.empty()) {
			res.add(s.pop());
		}
		
		return res;
	}

	public boolean isLeaf(TreeNode t) {
		return t.left == null && t.right == null;
	}

	public void addLeaves(List<Integer> res, TreeNode root) {
		if (isLeaf(root)) {
			res.add(root.val);
		} else {
			if (root.left != null) {
				addLeaves(res, root.left);
			}
			if (root.right != null) {
				addLeaves(res, root.right);
			}
		}
	}
}

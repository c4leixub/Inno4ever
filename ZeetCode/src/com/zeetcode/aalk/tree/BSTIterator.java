package com.zeetcode.aalk.tree;

import java.util.NoSuchElementException;
import java.util.Stack;

import com.zeetcode.node.TreeNode;

public class BSTIterator {

	private Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public int next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}

		TreeNode re = stack.pop();
		TreeNode p = re.right;
		while (p != null) {
			stack.push(p);
			p = p.left;
		}

		return re.val;
	}
}

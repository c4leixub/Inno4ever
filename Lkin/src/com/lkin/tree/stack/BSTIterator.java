package com.lkin.tree.stack;

import java.util.NoSuchElementException;
import java.util.Stack;

import com.common.structs.TreeNode;

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
		if (stack.isEmpty()) {
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

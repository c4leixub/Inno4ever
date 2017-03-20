package com.zeetcode.tree.Iterator;

import java.util.NoSuchElementException;
import java.util.Stack;

import com.zeetcode.node.TreeNode;

public class PreOrderIterator {
	Stack<TreeNode> stack = new Stack<TreeNode>();

	/** Constructor */
	public PreOrderIterator(TreeNode root) {
		if (root != null) {
			stack.push(root); // add to end of queue
		}
	}


	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public Integer next() {
		if (!hasNext()) {
			throw new NoSuchElementException("All nodes have been visited!");
		}

		TreeNode res = stack.pop(); // retrieve and remove the head of queue
		if (res.right != null)
			stack.push(res.right);
		if (res.left != null)
			stack.push(res.left);

		return res.val;
	}
}

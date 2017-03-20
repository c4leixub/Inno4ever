package com.zeetcode.tree.Iterator;

import java.util.NoSuchElementException;
import java.util.Stack;

import com.zeetcode.node.TreeNode;

public class PostOrderIterator {
	Stack<TreeNode> stack = new Stack<TreeNode>();

	/** find the first leaf in a tree rooted at cur and store intermediate nodes */
	private void findNextLeaf(TreeNode cur) {
		while (cur != null) {
			stack.push(cur);
			if (cur.left != null) {
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}
	}


	public PostOrderIterator(TreeNode root) {
		findNextLeaf(root);
	}


	public boolean hasNext() {
		return !stack.isEmpty();
	}


	public Integer next() {
		if (!hasNext()) {
			throw new NoSuchElementException("All nodes have been visited!");
		}

		TreeNode res = stack.pop();
		if (!stack.isEmpty()) {
			TreeNode top = stack.peek();
			if (res == top.left) {
				findNextLeaf(top.right); // find next leaf in right sub-tree
			}
		}

		return res.val;
	}
}

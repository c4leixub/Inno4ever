package com.goo.tree.stack;

import java.util.Stack;

import com.goo.node.TreeNode;

public class KthElementInTree {
	
	// O(n)
	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		int result = 0;

		while (p != null) {
			stack.add(p);
			p = p.left;
		}

		while (!stack.isEmpty()) {
			p = stack.pop();
			k--;

			if (k == 0) {
				result = p.val;
				break;
			}

			if (p.right != null) {
				p = p.right;
				while (p != null) {
					stack.add(p);
					p = p.left;
				}
			}
		}

		return result;
	}

	// O(height(BST)) if we know tree size
	public int kthSmallestWithAllNodeSize(TreeNode root, int k) {
		if (root == null) {
			return 0;
		}

		int leftNodes = getNumberNodes(root.left);
		if (k == leftNodes + 1) {
			return root.val;
		} else if (k > leftNodes + 1) {
			return kthSmallest(root.right, k - leftNodes - 1);
		} else {
			return kthSmallest(root.left, k);
		}
	}

	private int getNumberNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return getNumberNodes(root.left) + getNumberNodes(root.right) + 1;
	}
}

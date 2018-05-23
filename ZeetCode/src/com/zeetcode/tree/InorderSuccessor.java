package com.zeetcode.tree;

import com.zeetcode.node.TreeNode;

/*
 * Inorder successor for a BST
 */
public class InorderSuccessor {

	public Node getSuccessor(Node root, Node n) {
		if (root == null || n == null)
			return null;

		// return the leftMost/min of right tree
		if (n.right != null) {
			Node p = n.right;
			while (p.left != null) {
				p = p.left;
			}
			return p;
		}

		// One of the ancestors is successor. Travel up and stop
		// at a node which is left child of it’s parent.
		// The parent of such a node is the successor.
		Node p = n.parent;
		Node q = n;
		while (p != null && p.left != q) {
			q = p;
			p = p.parent;
		}
		return p;
	}

	public TreeNode inorderSuccessor(TreeNode root, TreeNode n) {
        if (root == null || n == null)
			return null;

		// return the leftMost/min of right tree
		if (n.right != null) {
			TreeNode p = n.right;
			while (p.left != null) {
				p = p.left;
			}
			return p;
		}
		
		// Travel up and stop when we find n, the sucessor
		// criteria is same as with "parent pointers", change
		// the parent whenever we go to left
		TreeNode parent = null;
		TreeNode p = root;
		while (p != null) {
			if (n.val < p.val) {	
				parent = p;
				p = p.left;
			} else {
				p = p.right;
			}
		}
		
		return parent;
    }

}

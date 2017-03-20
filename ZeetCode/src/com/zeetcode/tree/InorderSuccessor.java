package com.zeetcode.tree;
/*
 * Inorder successor for a BST
 */
public class InorderSuccessor {

	public static Node getSuccessor(Node root, Node n) {
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

	public static Node getSuccessorWithNoParent(Node root, Node n) {
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
		
		// Travel up and stop when we find n, the sucessor
		// criteria is same as with "parent pointers", change
		// the parent whenever we go to left
		Node parent = null;
		Node p = root;
		while (p != null) {
			if (n.value < p.value) {	
				parent = p;
				p = p.left;
			} else if (n.value > p.value) {
				p = p.right;
			} else {
				break;
			}
		}
		
		if (p == null)	// n is not in the tree;
			return null;	
		
		return parent;
	}

}

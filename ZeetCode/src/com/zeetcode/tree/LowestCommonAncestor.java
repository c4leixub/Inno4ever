package com.zeetcode.tree;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestor {

	/**
	 * Find the LCA of the Node p & q in the tree
	 * @param root The root of the tree
	 */
	public static Node getLowestCommonAncestor(Node root, Node p, Node q) {
		if (root == null) return null;
		if (root == p || root == q)	return root;
		
		Node L = getLowestCommonAncestor(root.left, p, q);
		Node R = getLowestCommonAncestor(root.right, p, q);
		
		if (L != null && R != null)	return root;
		
		return L != null ? L : R;
	}
	
	public static Node getLowestCommonAncestorWithParentAccess(Node p, Node q) {
		if (p == null || q == null) return null;
		
		// insert all the ancestor of p into a set
		Set<Node> parents = new HashSet<Node>();			
		Node pt = p;
		while (pt != null) {
			if(!parents.contains(pt)) {
				parents.add(pt);  
			}
			pt = pt.parent;
		}
		
		// visit each ancestor of q, return the first one
		// that is in the ancestor set of P
		pt = q;
		while (pt != null) {
			if(parents.contains(pt)) {
				return pt;
			}
			pt = pt.parent;
		}
		
		return null;
	}
	
	// If the tree is a binary tree
	public static Node getLowestCommonAncestorBST(Node root, Node p, Node q) {
		if (root == null || p == null || q == null) return null;
		
		if (p.value < root.value && q.value < root.value) {
			return getLowestCommonAncestorBST(root.left, p, q);
		} else if (p.value > root.value && q.value > root.value) {
			return getLowestCommonAncestorBST(root.right, p, q);
		}
		
		return root;
	}

}

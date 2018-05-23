package com.zeetcode.aalk.tree;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestor {

	/**
	 * Find the LCA of the Node p & q in the tree
	 * @param root The root of the tree
	 */
	public TreeNode getLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return null;
		if (root == p || root == q)	return root;
		
		TreeNode L = getLowestCommonAncestor(root.left, p, q);
		TreeNode R = getLowestCommonAncestor(root.right, p, q);
		
		if (L != null && R != null)	return root;
		
		return L != null ? L : R;
	}
	
	// If the tree is a binary tree
		public TreeNode getLowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
			if (root == null || p == null || q == null) return null;
			
			if (p.value < root.value && q.value < root.value) {
				return getLowestCommonAncestorBST(root.left, p, q);
			} else if (p.value > root.value && q.value > root.value) {
				return getLowestCommonAncestorBST(root.right, p, q);
			}
			
			return root;
		}
	
	public TreeNode getLowestCommonAncestorWithParentAccess(TreeNode p, TreeNode q) {
		if (p == null || q == null) return null;
		
		// insert all the ancestor of p into a set
		Set<TreeNode> parents = new HashSet<TreeNode>();			
		TreeNode pt = p;
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
}

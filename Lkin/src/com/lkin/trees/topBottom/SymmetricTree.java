package com.lkin.trees.topBottom;

import com.common.structs.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, the below binary tree is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        if (root == null)   return true;
	    return isSymmetric(root.left, root.right);
    }
 
    public boolean isSymmetric(TreeNode l, TreeNode r) {
	    if (l == null && r == null) {
		    return true;
	    }
	    
	    if (l != null && r != null && l.val == r.val) {
	        return isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
	    }
     
    	return false;
    }
}

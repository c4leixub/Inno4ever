package com.twt.ltc.tree;

import com.common.node.TreeNode;

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
        return isSymmetric(root.left, root.right);
    }
    
    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if ((p != null && q == null)
            || (p == null && q != null)) {
            return false;
        }
        
        if (p == null && q == null) {
            return true;
        }
        
        return p.val == q.val
            && isSymmetric(p.left, q.right)
            && isSymmetric(p.right, q.left);
    }
}

package com.zeetcode.aafb.tree;

import com.zeetcode.node.TreeNode;

public class IsSubtree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        
        if (s == null) {
            return false;
        }
        
        if (s.val == t.val) {
            if (isSameTree(s, t)) {
                return true;
            }
        }
        
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if ((s == null && t != null) || (s != null && t == null) || s.val != t.val) {
            return false;
        }
        
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}

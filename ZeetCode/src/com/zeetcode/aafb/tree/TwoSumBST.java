package com.zeetcode.aafb.tree;

import java.util.HashSet;
import java.util.Set;

import com.zeetcode.node.TreeNode;

public class TwoSumBST {
	public boolean findTarget(TreeNode root, int k) {
        return findTarget(root, k, new HashSet<Integer>());
    }
    
    public boolean findTarget(TreeNode root, int k, Set<Integer> s) {
        if (root == null) {
            return false;
        }
        
        if (s.contains(k-root.val)) {
            return true;
        }
        
        s.add(root.val);
        return findTarget(root.left, k, s) || findTarget(root.right, k, s);
    }
}

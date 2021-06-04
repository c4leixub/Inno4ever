package com.fcb.tree.bst;

import com.fcb.node.TreeNode;

public class RangeSumBST {
	public int rangeSumBST(TreeNode root, int L, int R) {
        
        if (root == null) {
            return 0;
        }
        
        int sum = 0;
        if (L <= root.val && root.val <= R) {
            sum += root.val;
        }
        
        if (L < root.val) {
            sum += rangeSumBST(root.left, L, R);
        }
        if (root.val < R) {
            sum += rangeSumBST(root.right, L, R);
        }
        
        return sum;
    }
}

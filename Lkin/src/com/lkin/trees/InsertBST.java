package com.lkin.trees;

import com.common.structs.TreeNode;

public class InsertBST {
	public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        
        insert(root, val);
        return root;
    }
    
    private void insert(TreeNode p, int value) {
		if (p.left == null && value < p.val) {
			p.left = new TreeNode(value);
		} else if (p.right == null && value > p.val) {
			p.right = new TreeNode(value);
		} else {
			if (value < p.val) {
				insert(p.left, value);
			} else {
				insert(p.right, value);
			}
		}
	}
}

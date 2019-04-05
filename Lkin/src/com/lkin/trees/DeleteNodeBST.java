package com.lkin.trees;

import com.common.structs.TreeNode;

public class DeleteNodeBST {
	public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            
            TreeNode min = root.right;
            while (min.left != null) {
                min = min.left;
            }
            
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);
        }
        
        return root;
    }
}

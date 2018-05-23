package com.zeetcode.aafb.tree;

import com.zeetcode.node.TreeNode;

public class Diameter {
	
	public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[] {0};
        getHeight(root, res);
        
        return res[0];
    }
    
    public int getHeight(TreeNode root, int[] res) {
        if (root == null) return 0;
        
        int left = getHeight(root.left, res);
        int right = getHeight(root.right, res);
        
        res[0] = Math.max(res[0], left + right);
        
        int h = Math.max(left, right) + 1;
        
        return h;
    }
}

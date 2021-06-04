package com.goo.tree.bottomup;

import com.goo.node.TreeNode;

public class DistrubuteCoinBinaryTree {
	
	public int distributeCoins(TreeNode root) {
        int[] ans = new int[1];
        dfs(root, ans);
        return ans[0];
    }
    
    public int dfs(TreeNode node, int[] ans) {
        if (node == null) return 0;
        int L = dfs(node.left, ans);
        int R = dfs(node.right, ans);
        ans[0] += Math.abs(L) + Math.abs(R);
        return node.val + L + R - 1;
    }
}

package com.goo.tree.bottomup;

import com.goo.node.TreeNode;

/**
 * 687 https://leetcode.com/problems/longest-univalue-path/
 * @author xlei
 *
 */
public class LongestUnivaluePath {
	public int longestUnivaluePath(TreeNode root) {
        int[] ans = new int[1];
        arrowLength(root, ans);
        return ans[0];
    }
    
    public int arrowLength(TreeNode node, int[] ans) {
        if (node == null) return 0;
        
        int left = arrowLength(node.left, ans);
        int right = arrowLength(node.right, ans);
        int arrowLeft = 0, arrowRight = 0;
        
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        
        ans[0] = Math.max(ans[0], arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}

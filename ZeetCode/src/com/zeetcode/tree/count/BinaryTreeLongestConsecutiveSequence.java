package com.zeetcode.tree.count;

import com.zeetcode.node.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {
	public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        
        return Math.max(longestConsecutive(root, root.left, 1), longestConsecutive(root, root.right, 1));
    }
    
    public int longestConsecutive(TreeNode parent, TreeNode cur, int count) {
        if (cur == null) return count;
        
        if (parent.val + 1 != cur.val) {
            return Math.max(Math.max(count, longestConsecutive(cur, cur.left, 1)), longestConsecutive(cur, cur.right, 1));
        }
        
        return Math.max(longestConsecutive(cur, cur.left, count+1), longestConsecutive(cur, cur.right, count+1));
    }
}

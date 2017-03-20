package com.zeetcode.tree;

import java.util.LinkedList;

import com.zeetcode.node.TreeNode;

public class DepthOfTree {
	public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
 
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> counts = new LinkedList<Integer>();
 
        nodes.add(root);
        counts.add(1);
 
        while(!nodes.isEmpty()){
            TreeNode curr = nodes.remove();
            int count = counts.remove();
 
            if(curr.left == null && curr.right == null){
                return count;
            }
 
            if(curr.left != null){
                nodes.add(curr.left);
                counts.add(count+1);
            }
 
            if(curr.right != null){
                nodes.add(curr.right);
                counts.add(count+1);
            }
        }
 
        return 0;
    }
	
	public int maxDepth(TreeNode root) {
	    if(root==null)
	        return 0;
	 
	    int leftDepth = maxDepth(root.left);
	    int rightDepth = maxDepth(root.right);
	 
	    int bigger = Math.max(leftDepth, rightDepth);
	 
	    return bigger+1;
	}
}

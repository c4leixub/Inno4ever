package com.lkin.tree.stack;

import java.util.Stack;

import com.common.structs.TreeNode;

/**
    1					 4
   / \					/ \
  2   3		->		   5   2
 / \				  	  / \
4   5				 	 3   1
*/
public class FlipTreeUpSideDown {
	public TreeNode flip(TreeNode root) {
		if (root == null)	return root;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode left = root;
		while (left != null) {
			stack.push(left);
			left = left.left;
		}
		
		
		TreeNode newRoot = stack.peek();
		TreeNode node;
		while (!stack.isEmpty()) {
			node = stack.pop();
			
			if (stack.isEmpty()) {
				node.left = null;
				node.right = null;
			} else {
				node.left = stack.peek().right;
				node.right = stack.peek();
			}
		}
		
		return newRoot;
	}
	
	public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null, next = null, tmp = null;
        while (cur != null) {
            next = cur.left;
            
            cur.left = tmp;
            tmp = cur.right;
            
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        
        return pre;
    }
}

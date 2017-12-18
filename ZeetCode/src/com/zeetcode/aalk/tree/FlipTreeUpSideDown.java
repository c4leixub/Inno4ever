package com.zeetcode.aalk.tree;

import java.util.Stack;

import com.zeetcode.node.TreeNode;

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
	
	public static void main(String[] args) {
		FlipTreeUpSideDown f = new FlipTreeUpSideDown();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(6);
		root.left.left.right = new TreeNode(7);
		
		root = f.flip(root);
		System.out.println(root);
		
		System.out.print(root.left);
		System.out.println(root.right);
		
		System.out.print(root.left.left );
		System.out.print(root.right.left);
		System.out.println(root.right.right);
		
		System.out.print(root.right.left.left);
		System.out.print(root.right.right.left);
		System.out.println(root.right.right.right);
		
		System.out.print(root.right.right.left.right);
		System.out.println(root.right.right.right.right);
				
	}
}

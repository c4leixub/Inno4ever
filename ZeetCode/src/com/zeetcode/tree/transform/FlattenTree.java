package com.zeetcode.tree.transform;

import com.zeetcode.node.TreeNode;


public class FlattenTree {
	
	public static void flatten(TreeNode root) {
		if (root != null) {
			flatHelp(root);
		}
	}
	
	public static TreeNode flatHelp(TreeNode root) {
		if (root.left == null && root.right == null) { 
			return root;
		}
		
		if (root.left == null) return flatHelp(root.right);
		
		TreeNode right = root.right;
		
		TreeNode last = flatHelp(root.left);
		last.right = right;
		
		root.right = root.left;
		root.left = null;
		
		return flatHelp(last.right);
	}
	
	public static void flat(TreeNode root) {
		if (root == null) return;
		if (root.left == null) return;
		
		TreeNode right = root.right;
		flat(root.left);
		TreeNode last = getRightMost(root.left);
		if (last != null) {
			last.right = right;
			root.right = root.left;
			root.left = null;
		}
		
		flat(last.right);
	}
	
	public static TreeNode getRightMost(TreeNode root) {
		if (root == null) return null;
		TreeNode n = root;
		while (n.right != null) {
			n = n.right;
		}
		return n;
	}
	
	public static void main(String[] args) {		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		
		//flat(root);
		flatten(root);
		TreeNode n = root;
		while (n != null) {
			System.out.print(n.val + " ");
			n = n.right;
		}
	}
}

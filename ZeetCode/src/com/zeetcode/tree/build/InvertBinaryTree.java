package com.zeetcode.tree.build;

import com.zeetcode.node.TreeNode;
import com.zeetcode.tree.verify.SymmetricTree;

/**
 * Invert (aka build mirror) a binary tree. Ex.
     4			
   /   \
  2     7
 / \   / \
1   3 6   9
-----to-----
 	 4
   /   \
  7     2
 / \   / \
9   6 3   1
 */
public class InvertBinaryTree {
	public TreeNode invertTreeNew(TreeNode root) {
		if (root == null) {
		     return null;
		}
	
		TreeNode newNode = new TreeNode(root.val);
		newNode.left = invertTreeNew(root.right);
		newNode.right = invertTreeNew(root.left);
		
		return newNode;
	}
	
	public TreeNode invertTree(TreeNode root) {
        invertTreeHelper(root);
        return root;
    }
    
    public void invertTreeHelper(TreeNode root) {
        if (root == null)   return;
        
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        
        invertTreeHelper(root.left);
        invertTreeHelper(root.right);
    }
    
    public static void main(String[] args) {
    	InvertBinaryTree b = new InvertBinaryTree();
    	SymmetricTree s = new SymmetricTree();
    	
    	TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		
//		TreeNode mirror= new TreeNode(1);
//		mirror.left = new TreeNode(2);
//		mirror.right = new TreeNode(7);
//		mirror.left.left = new TreeNode(1);
//		mirror.left.right = new TreeNode(3);
//		mirror.right.left = new TreeNode(6);
//		mirror.right.right = new TreeNode(9);
//		b.invertTree(mirror);
		
		System.out.println(s.isSymmetric(root, b.invertTreeNew(root)));
    }
}

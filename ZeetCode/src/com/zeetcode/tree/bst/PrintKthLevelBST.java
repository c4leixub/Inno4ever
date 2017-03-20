package com.zeetcode.tree.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.zeetcode.node.TreeNode;
import com.zeetcode.tree.build.InvertBinaryTree;
import com.zeetcode.tree.verify.SymmetricTree;

public class PrintKthLevelBST {
	
	public List<Integer> getKthLevel(TreeNode root, int k) {
		
		LinkedList<TreeNode> q1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> q2 = new LinkedList<TreeNode>();
		q1.add(root);
		k--;
		
		while (!q1.isEmpty() && k > 0) {
			
			while (!q1.isEmpty()) {
				TreeNode node = q1.poll();
				if (node.left != null) q2.add(node.left);
				if (node.right != null) q2.add(node.right);
			}
			
			LinkedList<TreeNode> t = q2;
			q2 = q1;
			q1 = t;
			k--;
		}
		
		List<Integer> result = new ArrayList<Integer>();
		if (q1.size() == 1) {
			result.add(q1.get(0).val);
			return result;
		}
		
		int i = 0;
		while (i < q1.size() / 2) {
			result.add(q1.get(i).val);
			result.add(q1.get(q1.size()-1-i).val);
			i++;
		}
		
		return result;
	} 
	
	public static void main(String[] args) {
    	TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(3);
		//root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(25);
		root.left.left = new TreeNode(3);
		
	
		PrintKthLevelBST p = new PrintKthLevelBST();
		System.out.println(p.getKthLevel(root, 3));
	}
}

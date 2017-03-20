package com.zeetcode.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.zeetcode.node.TreeNode;

public class ZigZagTranversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		s1.add(root);
		
		TreeNode e;
		List<Integer> list;
		while (!s1.isEmpty() || !s2.isEmpty()) {
			
			list = new ArrayList<Integer>();
			while (!s1.isEmpty()) {
				e = s1.pop();
				list.add(e.val);
				if (e.left != null) s2.add(e.left);
				if (e.right != null) s2.add(e.right);
			}
			result.add(list);
			
			if (s2.isEmpty()) break;
			list = new ArrayList<Integer>();
			while (!s2.isEmpty()) {
				e = s2.pop();
				list.add(e.val);
				if (e.right != null) s1.add(e.right);
				if (e.left != null) s1.add(e.left);
			}
			result.add(list);
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		ZigZagTranversal z = new ZigZagTranversal();
		
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		
		for (List<Integer> list : z.zigzagLevelOrder(root)) {
			System.out.println(list);
		}
	}
}

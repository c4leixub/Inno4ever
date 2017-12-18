package com.zeetcode.aalk.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.zeetcode.node.TreeNode;

public class ZigZagTranversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
		
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		s1.add(root);
		
		while (!s1.isEmpty()) {
			traverseOneLevel(s1, s2, result, true);
			
			if (s2.isEmpty()) break;
			
			traverseOneLevel(s2, s1, result, false);
		}
		
		return result;
    }
	
	public void traverseOneLevel(Stack<TreeNode> s1, Stack<TreeNode> s2, List<List<Integer>> result, boolean addLeftFirst) {
		TreeNode e;
		List<Integer> list = new ArrayList<Integer>();
		while (!s1.isEmpty()) {
			e = s1.pop();
			list.add(e.val);
			
			if (addLeftFirst) {
				if (e.left != null) s2.add(e.left);
				if (e.right != null) s2.add(e.right);
			} else {
				if (e.right != null) s2.add(e.right);
				if (e.left != null) s2.add(e.left);
			}
		}
		result.add(list);
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

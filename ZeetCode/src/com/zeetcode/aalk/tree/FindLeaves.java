package com.zeetcode.aalk.tree;

import java.util.ArrayList;
import java.util.List;

import com.zeetcode.node.TreeNode;

/**
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].
 */
public class FindLeaves {
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(result, root);
		return result;
	}

	// traverse the tree bottom-up recursively
	private int helper(List<List<Integer>> list, TreeNode root) {
		if (root == null)
			return -1;

		int left = helper(list, root.left);
		int right = helper(list, root.right);
		int curr = Math.max(left, right) + 1;

		// the first time this code is reached is when curr==0,
		// since the tree is bottom-up processed.
		if (list.size() <= curr) {
			list.add(new ArrayList<Integer>());
		}

		list.get(curr).add(root.val);

		return curr;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		FindLeaves f = new FindLeaves();
		System.out.println(f.findLeaves(root));
	}
}

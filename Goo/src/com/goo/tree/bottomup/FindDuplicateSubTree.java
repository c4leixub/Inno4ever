package com.goo.tree.bottomup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.goo.node.TreeNode;

/**
 * 652 https://leetcode.com/problems/find-duplicate-subtrees/
 * 
 * Time Complexity: O(N^2) where N is the number of nodes in the tree. 
 * We visit each node once, but each creation of serial may take O(N) work.
 * 
 * Space Complexity: O(N^2) the size of hashmap.
 *
 */
public class FindDuplicateSubTree {
	
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> result = new ArrayList<>();
		if (root != null) {
			findDuplicateSubtrees(root, result, new HashMap<String, Integer>());
		}
		return result;
	}

	public String findDuplicateSubtrees(TreeNode node, List<TreeNode> result, Map<String, Integer> visited) {
		if (node == null) {
			return "#";
		}

		String res = String.valueOf(node.val) + "," + findDuplicateSubtrees(node.left, result, visited) + ","
				+ findDuplicateSubtrees(node.right, result, visited);

		visited.put(res, visited.getOrDefault(res, 0) + 1);
		if (visited.get(res) == 2) {
			result.add(node);
		}

		return res;
	}
}

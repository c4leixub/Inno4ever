package com.zeetcode.aalk.tree;

import com.zeetcode.node.TreeNode;

/**
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

 * Input: 
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.

Example 2:
Input: 
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
 *
 */
public class SecondMinBinaryTree {
	public int findSecondMinimumValue(TreeNode root) {
		if (root == null || root.left == null) {
			return -1;
		}
		if (root.val == root.left.val && root.left.val == root.right.val) {
            return -1;
        }
		
		return findSecondMinimumValue(root, root.val, Integer.MAX_VALUE);
	}

	private int findSecondMinimumValue(TreeNode node, int first, int second) {
		if (node == null) {
			return second;
		}

		if (node.val != first && node.val < second) {
			second = node.val;
		}

		return Math.min(findSecondMinimumValue(node.left, first, second),
							findSecondMinimumValue(node.right, first, second));
	}
}

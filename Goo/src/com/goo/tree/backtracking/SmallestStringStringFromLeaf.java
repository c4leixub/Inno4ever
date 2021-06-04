package com.goo.tree.backtracking;

import com.goo.node.TreeNode;

/**
 * 988 https://leetcode.com/problems/smallest-string-starting-from-leaf/
 * @author xlei
 *
 */
public class SmallestStringStringFromLeaf {

	String ans = null;

	public String smallestFromLeaf(TreeNode root) {
		if (root == null) {
			return "";
		}
		smallestFromLeaf(root, new StringBuilder());
		return ans;
	}

	public void smallestFromLeaf(TreeNode node, StringBuilder sb) {
		char c = (char) ('a' + node.val);
		sb.append(c);

		if (node.left == null && node.right == null) {
			StringBuilder w = new StringBuilder(sb.toString());
			w.reverse();
			String word = w.toString();

			if (ans == null || word.compareTo(ans) < 0) {
				ans = word;
			}
			return;
		}

		if (node.left != null) {
			smallestFromLeaf(node.left, sb);
			sb.deleteCharAt(sb.length() - 1);
		}

		if (node.right != null) {
			smallestFromLeaf(node.right, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}

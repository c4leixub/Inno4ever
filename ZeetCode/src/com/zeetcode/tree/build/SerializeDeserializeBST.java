package com.zeetcode.tree.build;

import java.util.ArrayList;
import java.util.List;

import com.zeetcode.node.TreeNode;

public class SerializeDeserializeBST {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder result = new StringBuilder();
		serialize(root, result);

		if (result.length() > 0) {
			result.deleteCharAt(result.length() - 1);
		}
		return result.toString();
	}

	// preorder traversal
	private void serialize(TreeNode root, StringBuilder result) {
		if (root == null)
			return;

		result.append(root.val);
		result.append(",");
		serialize(root.left, result);
		serialize(root.right, result);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.isEmpty())
			return null;

		String[] vals = data.split(",");
		if (vals.length == 0)
			return null;

		TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
		TreeNode p = root;
		int i = 1;
		int nextVal;

		while (i < vals.length) {
			nextVal = Integer.parseInt(vals[i]);
			insert(root, nextVal);
			i++;
		}

		return root;
	}

	private void insert(TreeNode p, int value) {
		if (p.left == null && value < p.val) {
			p.left = new TreeNode(value);
		} else if (p.right == null && value > p.val) {
			p.right = new TreeNode(value);
		} else {
			if (value < p.val) {
				insert(p.left, value);
			} else {
				insert(p.right, value);
			}
		}
	}
}

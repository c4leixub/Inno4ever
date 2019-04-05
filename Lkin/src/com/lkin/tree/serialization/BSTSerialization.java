package com.lkin.tree.serialization;

import com.common.structs.TreeNode;

public class BSTSerialization {

	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serializeHelper(root, sb);
		return sb.toString();
	}

	// pre-order traversal
	private void serializeHelper(TreeNode root, StringBuilder sb) {
		if (root == null) {
			return;
		}

		sb.append(root.val);
		sb.append(',');
		serializeHelper(root.left, sb);
		serializeHelper(root.right, sb);
	}

	public TreeNode deserialize(String data) {
		if (data == null || data.isEmpty()) {
			return null;
		}

		String[] vals = data.split(",");
		if (vals.length == 0)
			return null;

		TreeNode root = deserializeHelper(vals, new int[] { 0 }, Integer.MIN_VALUE, Integer.MAX_VALUE);

		// TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
		// int nextVal;
		// for (int i = 1; i < vals.length; i++) {
		// nextVal = Integer.parseInt(vals[i]);
		// insert(root, nextVal);
		// }

		return root;
	}

	private TreeNode deserializeHelper(String[] vals, int[] pos, int min, int max) {
		if (pos[0] >= vals.length) {
			return null;
		}

		int val = Integer.parseInt(vals[pos[0]]);
		if (val < min || val > max) {
			return null;
		}

		TreeNode root = new TreeNode(val);
		pos[0]++;
		root.left = deserializeHelper(vals, pos, min, val);
		root.right = deserializeHelper(vals, pos, val, max);
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

	public static void main(String[] args) {
		BSTSerialization b = new BSTSerialization();

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(11);
		String data = b.serialize(root);
		System.out.println(data);

		TreeNode newRoot = b.deserialize(data);
	}
}

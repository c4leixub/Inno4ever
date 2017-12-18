package com.zeetcode.aalk.tree;

import java.util.LinkedList;

import com.zeetcode.node.TreeNode;

/**
 * For example, you may serialize the following tree
 * 1 / \ 2 3 / \ 4 5 as "[1,2,3,null,null,4,5]
 */
public class SerializeDeserializeBinaryTree {
	public static String serialize(TreeNode root) {
		if (root == null)
			return "[]";

		StringBuilder sb = new StringBuilder();
		sb.append("[");
		StringBuilder nulls = new StringBuilder();

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode p = queue.poll();

			if (p != null) {

				if (nulls.length() > 0) {
					sb.append(nulls.toString());
					nulls = new StringBuilder();
				}
				sb.append(p.val);
				sb.append(",");

				queue.add(p.left);
				queue.add(p.right);
			} else {
				nulls.append("null");
				nulls.append(",");
			}
		}

		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}

	public static TreeNode deserialize(String data) {
		if (data == null || data.isEmpty())	return null;

		data = data.substring(1, data.length() - 1); // cut the '[' and ']'
		String[] vals = data.split(",");
		if (vals.length == 0 || vals[0].isEmpty())	return null;

		TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		int index = 1;
		while (index < vals.length && !queue.isEmpty()) {
			TreeNode p = queue.poll();

			if ("null".equals(vals[index])) {
				p.left = null;
			} else {
				p.left = new TreeNode(Integer.parseInt(vals[index]));
				queue.add(p.left);
			}
			index++;

			if (index >= vals.length) {
				break;
			}

			if ("null".equals(vals[index])) {
				p.right = null;
			} else {
				p.right = new TreeNode(Integer.parseInt(vals[index]));
				queue.add(p.right);
			}
			index++;
		}
		return root;
	}

	public static void main(String[] args) {
		//TreeNode nullCase = deserialize("[]");

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(6);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);

		String s = serialize(root);
		System.out.println(s);

		TreeNode loot = deserialize(s);
		System.out.print(loot.val + ", ");
		System.out.print(loot.left.val + ", ");
		System.out.print(loot.right.val + ", ");

		System.out.print(loot.left.left + ", ");
		System.out.print(loot.left.right + ", ");

		System.out.print(loot.right.left.val + ", ");
		System.out.print(loot.right.right.val + ", ");

	}
}

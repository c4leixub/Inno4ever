package com.zeetcode.aafb.tree;

public class PopulateNextPointer {

	class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		TreeLinkNode dump = new TreeLinkNode(0), t = dump;

		TreeLinkNode node = root;
		while (node != null) {
			if (node.left != null) {
				t.next = node.left;
				t = t.next;
			}
			if (node.right != null) {
				t.next = node.right;
				t = t.next;
			}

			node = node.next;
			if (node == null) {
				t = dump;
				node = dump.next;
				dump.next = null;
			}
		}
	}

	public void connectCompleteTree(TreeLinkNode root) {
		if (root == null)	return;
		
		TreeLinkNode start = root, cur = null;
		while (start.left != null) {
			cur = start;
			while (cur != null) {
				cur.left.next = cur.right;
				if (cur.next != null) {
					cur.right.next = cur.next.left;
				}
				cur = cur.next;
			}

			start = start.left;
		}
	}

}

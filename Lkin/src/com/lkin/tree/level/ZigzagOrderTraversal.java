package com.lkin.tree.level;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.common.structs.TreeNode;

public class ZigzagOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}

		Stack<TreeNode> cur = new Stack<TreeNode>();
		Stack<TreeNode> next = new Stack<TreeNode>();
		Stack<TreeNode> t;
        boolean isLeftFirst = true;

		TreeNode node;
		cur.add(root);
		while (!cur.isEmpty()) {

			List<Integer> list = new ArrayList<Integer>();
			while (!cur.isEmpty()) {
				node = cur.pop();
				list.add(node.val);

                if (isLeftFirst) {
                    if (node.left != null) {
					next.add(node.left);
                    }
                    if (node.right != null) {
                        next.add(node.right);
                    }
                } else {
                    if (node.right != null) {
                        next.add(node.right);
                    }
                    if (node.left != null) {
					next.add(node.left);
                    }
                }
			}
            isLeftFirst = !isLeftFirst;

			result.add(list);
			t = cur;
			cur = next;
			next = t;
		}

		return result;
    }
}

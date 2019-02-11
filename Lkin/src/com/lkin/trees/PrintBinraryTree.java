package com.lkin.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.common.structs.TreeNode;

public class PrintBinraryTree {

	public List<List<String>> printTree(TreeNode root) {
		List<List<String>> result = new ArrayList<List<String>>();
		if (root == null) {
			return result;
		}
		
		int height = getHeight(root), width = (int) Math.pow(2, height) - 1;
		for (int i = 0; i < height; i++) {
			List<String> list = new ArrayList<String>();
			for (int j = 0; j < width; j++) {
				list.add("");
			}
			result.add(list);
		}
        fill(root, result, 0, 0, width - 1);
		
        return result;
    }
	
	private void fill(TreeNode node, List<List<String>> result, int h, int l, int r) {
		if (node == null) {
			return;
		}
		
		int m = l + (r - l) / 2;
		result.get(h).set(m, String.valueOf(node.val));
		fill(node.left, result, h+1, l, m-1);
		fill(node.right, result, h+1, m+1, r);
	}
	
	private int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	public static void main(String[] args) {
		PrintBinraryTree p = new PrintBinraryTree();
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(11);
		
		System.out.println(p.printTree(root));
		
	}
}

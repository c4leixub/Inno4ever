package com.zeetcode.tree;

import java.util.ArrayList;
import java.util.List;

import com.zeetcode.node.TreeNode;

/**
 * A 
  / \ 
  B C 
 / / \ 
D E   F 

打印所有path ABD ACE ACF 
 */
public class GetAllPath {
	
	public List<List<TreeNode>> getAllPath(TreeNode root) {
		List<List<TreeNode>> ret = new ArrayList<List<TreeNode>>();
		if (root == null) {
			return ret;
		}
		
		getAllPath(root, new ArrayList<TreeNode>(), ret);
		
		return ret;
	}
	
	public void getAllPath(TreeNode root, List<TreeNode> path,
							List<List<TreeNode>> ret) {
		
		if (root.left == null && root.right == null) {
			path.add(root);
			ret.add(new ArrayList<TreeNode>(path));
			return;
		}
		
		path.add(root);
		if (root.left != null) {
			getAllPath(root.left, path, ret);
			path.remove(path.size() - 1);
		}
		if (root.right != null) {
			getAllPath(root.right, path, ret);
			path.remove(path.size() - 1);
		}
		

	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.right = new TreeNode(7);
		
		GetAllPath tree = new GetAllPath();
		System.out.println(tree.getAllPath(root));
	}
}

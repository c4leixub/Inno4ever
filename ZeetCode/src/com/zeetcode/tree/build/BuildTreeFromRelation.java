package com.zeetcode.tree.build;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.zeetcode.node.TreeNode;
import com.zeetcode.tree.traversal.LevelOrderTraversal;

public class BuildTreeFromRelation {

	public static class Relation {
		public Integer child;
		public Integer parent;
		public boolean isLeft;

		public Relation(Integer child, Integer parent, boolean isLeft) {
			this.child = child;
			this.parent = parent;
			this.isLeft = isLeft;
		}
	}

	public TreeNode buildBinaryTree(List<Relation> relations) {

		TreeNode root = null;
		HashMap<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();

		for (Relation r : relations) {
			if (r.parent == null) {	// found the root
				if (map.containsKey(r.child)) {	// the root node is already in the map
					root = map.get(r.child);
				} else {
					root = new TreeNode(r.child);
					map.put(r.child, root);
				}
				continue;
			}
			
			TreeNode parent = map.get(r.parent);
			if (parent == null) {
				parent = new TreeNode(r.parent);
				map.put(r.parent, parent);
			}
			
			TreeNode child = map.get(r.child);
			if (child == null) {
				child = new TreeNode(r.child);
				map.put(r.child, child);
			}

			if (r.isLeft) {
				parent.left = child;
			} else {
				parent.right = child;
			}
		}

		return root;
	}

	public static void main(String[] args) {
		
		BuildTreeFromRelation b = new BuildTreeFromRelation();
		
		List<Relation> relations = new ArrayList<Relation>();
		relations.add(new Relation(15, 20, true));
		relations.add(new Relation(19, 80, true));
		relations.add(new Relation(17, 20, false));
		relations.add(new Relation(16, 80, false));
		relations.add(new Relation(80, 50, false));
		relations.add(new Relation(50, null, false));
		relations.add(new Relation(20, 50, true));
		
		TreeNode root = b.buildBinaryTree(relations);
		LevelOrderTraversal t = new LevelOrderTraversal();
		for (List<Integer> e : t.levelOrder(root)) {
			System.out.println(e);
		}
		
	}
}

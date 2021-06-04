package com.goo.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.goo.node.TreeNode;

public class DeleteNodesAndReturnForest {
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Set<Integer> numToDelete = new HashSet<>();
        for (int d : to_delete) {
            numToDelete.add(d);
        }
        
        result.add(root);
        
        delNodes(null, root, true, result, numToDelete);
        return result;
    }
    
    public void delNodes(TreeNode pre, TreeNode node, boolean isLeft, List<TreeNode> result, Set<Integer> numToDelete) {
        if (node == null) {
            return;
        }
        
        if (numToDelete.contains(node.val)) {
            if (pre != null) {
                if (isLeft) {
                    pre.left = null;
                } else {
                    pre.right = null;
                }
            } else {
                // root is the number to delete
                result.remove(result.size()-1);
            }
            
            if (node.left != null && !numToDelete.contains(node.left.val)) {
                result.add(node.left);
            }
            if (node.right != null && !numToDelete.contains(node.right.val)) {
                result.add(node.right);
            }
        }
        
        delNodes(node, node.left, true, result, numToDelete);
        delNodes(node, node.right, false, result, numToDelete);
    }
}

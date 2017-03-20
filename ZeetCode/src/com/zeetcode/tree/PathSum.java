package com.zeetcode.tree;

import java.util.ArrayList;
import java.util.List;

import com.zeetcode.node.TreeNode;

public class PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null 
                //|| (root.left != null || root.right != null)
            ) {
            return false;
        }
        
        return hasPathSumHelp(root, sum);
    }
    
    public boolean hasPathSumHelp(TreeNode root, int sum) {
        if (root == null) {
            return sum == 0;
        }
        
        return hasPathSumHelp(root.left, sum-root.val)
                || hasPathSumHelp(root.right, sum-root.val);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (root == null) {
			return ret;
		}
		
		pathSum(root, new ArrayList<Integer>(), ret, sum);
		return ret;
    }
    
    public void pathSum(TreeNode root, List<Integer> list, List<List<Integer>> ret, int sum) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
            if (sum - root.val == 0) {
                ret.add(new ArrayList(list));
            }
            return;
        }
        
        list.add(root.val);
        if (root.left != null) {
            pathSum(root.left, list, ret, sum-root.val);
            list.remove(list.size() - 1);
        }
        
        if (root.right != null) {
            pathSum(root.right, list, ret, sum-root.val);
            list.remove(list.size() - 1);
        }
    }
}

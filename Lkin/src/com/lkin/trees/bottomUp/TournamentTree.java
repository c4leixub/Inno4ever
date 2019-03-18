package com.lkin.trees.bottomUp;

import com.common.structs.TreeNode;

/**
 * The Tournament tree has following properties
 * 
 * Node has either 0 or 2 child
 * The node.left.val = node.val or node.right.val = node.val
 * a child that is greater than node.val
 */
public class TournamentTree {
	
	public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) {
            return -1;
        }
        
        if (root.left.val == root.val) {
            int leftSecondMin = findSecondMinimumValue(root.left);
            
            if (leftSecondMin == -1 || leftSecondMin > root.right.val) {
                return root.right.val;
            } else {
                return leftSecondMin;
            }
        } else {
            int rightSecondMin = findSecondMinimumValue(root.right);
            
            if(rightSecondMin == -1 || rightSecondMin > root.left.val) {
                return root.left.val;
            } else {
                return rightSecondMin;
            }
        }
    }
}

package com.zeetcode.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.zeetcode.node.TreeNode;

// Get all last child at each level
public class RightSideView {
	public void rightSideViewDFS(TreeNode root, List<Integer> result, int depth) {
		if(root == null){
            return;
        }
        if(depth == result.size()){
            result.add(root.val);
        }

        rightSideViewDFS(root.right, result, depth + 1);
        rightSideViewDFS(root.left, result, depth + 1);
	}
	
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        
        TreeNode n;
        while (!q.isEmpty()) {
            n = q.poll();
            
            if (n.left != null) {
                next.add(n.left);
            }
                
            if (n.right != null) {
                next.add(n.right);
            }
            
            if (q.size() == 0) {
                result.add(n.val);
                
                Queue<TreeNode> t = q;
                q = next;
                next = t;
            }
        }
        
        return result;
    }
}

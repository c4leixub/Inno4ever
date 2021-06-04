package com.goo.tree.levelorder;

import java.util.LinkedList;
import java.util.Queue;

import com.goo.node.TreeNode;

public class CBTInserter {
	
	private TreeNode root;
    private Queue<TreeNode> queue;
    
    
    public CBTInserter(TreeNode root) {
        this.root = root;
        this.queue = new LinkedList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        TreeNode node;
        while (!q.isEmpty()) {
            node = q.poll();
            if (node.left == null || node.right == null) {
                queue.add(node);
            }
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }
    
    public int insert(int v) {
        TreeNode node = queue.peek();
        TreeNode newNode = new TreeNode(v);
        
        if (node.left == null) {
            node.left = newNode;
        } else {
            node.right = newNode;
            queue.poll();
        }
        queue.add(newNode);
        
        return node.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

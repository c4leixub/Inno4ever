package com.lkin.tree.serialization;

import java.util.LinkedList;
import java.util.Queue;

import com.common.structs.TreeNode;

public class BinaryTreeSerailization {
	
	public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
		sb.append('[');
        if (root == null) {
            sb.append(']');
			return sb.toString();
		}
        
        StringBuilder nulls = new StringBuilder();
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node != null) {
            	if (nulls.length() > 0) {
            		sb.append(nulls.toString());
					nulls = new StringBuilder();
            	}
            	
                sb.append(node.val);
                sb.append(',');
                
                queue.add(node.left);
                queue.add(node.right);
            } else {
                nulls.append("null");
                nulls.append(',');
            }
        }
        
        sb.setCharAt(sb.length()-1, ']');
        return sb.toString();
    }
	
	public TreeNode deserialize(String data) {
		if (data == null || data.isEmpty() || data.equals("[]")) {
			return null;
		}
		
		boolean isNull = false;
		TreeNode root = null, node;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int i = 1, val = 0, m = 1;
        
		// Compute the root
		while (i < data.length() - 1 && data.charAt(i) != ',') {
        	if (data.charAt(i) == '-') {
        		m = -1;
        	} else {
        		val = val * 10 + (data.charAt(i) - '0');
        	}
        	i++;
        }
		root = new TreeNode(val * m);
		queue.add(root);
		val = 0;
		i++;
		
		
        while (i < data.length() - 1 && !queue.isEmpty()) {
        	node = queue.poll();
        	
        	val = 0; m = 1;
        	isNull = false;
        	while (i < data.length() - 1 && data.charAt(i) != ',') {
        		if (data.charAt(i) == '-') {
            		m = -1;
            		i++;
            	} else if (Character.isDigit(data.charAt(i))) {
	        		val = val * 10 + (data.charAt(i) - '0');
	        		i++;
	        	} else {	// it's null
	        		isNull = true;
	        		i += 4;
	        	}
        	}
        	
        	if (isNull) {
        		node.left = null;
        	} else {
        		node.left = new TreeNode(val);
        		queue.add(node.left);
        	}
        	i++;
        	
        	if (i >= data.length() - 1) {
        		break;
        	}
        	
        	val = 0; m = 1;
        	isNull = false;
        	while (i < data.length() - 1 && data.charAt(i) != ',') {
        		if (data.charAt(i) == '-') {
            		m = -1;
            		i++;
            	} else if (Character.isDigit(data.charAt(i))) {
	        		val = val * 10 + (data.charAt(i) - '0');
	        		i++;
	        	} else {	// it's null
	        		isNull = true;
	        		i += 4;
	        	}
        	}
        	
        	if (isNull) {
        		node.right = null;
        	} else {
        		node.right = new TreeNode(val);
        		queue.add(node.right);
        	}
        	i++;
        }
        
        return root;
    }
	
	public static void main(String[] args) {
		BinaryTreeSerailization b = new BinaryTreeSerailization();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(6);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		String data = b.serialize(root);
		System.out.println(data);
		
		TreeNode copy = b.deserialize("[1,-1,2,-2]");
		
		System.out.println(copy);
	}
}

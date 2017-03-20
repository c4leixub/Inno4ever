package com.zeetcode.tree.transform;

import java.util.LinkedList;
import java.util.Queue;

import com.zeetcode.tree.Node;

public class PopulateNextPointer {

	public static void populateNextPointerPerfect(Node root) {		
		Node p = root;
		Node first = null;
		while (p != null) {
			if (first == null) first = p.left;
			
			if (p.left != null) {
				p.left.next = p.right;
			} else {	 // leaf level, the end
				break; 
			}
			
			if (p.next != null) {
				p.right.next = p.next.left;
				p = p.next;
			} else {		// to the next level
				p = first;
				first = null;
			}
		}
	}	
	
	// For tree that is not perfect
	public static void populateNextPointerNonPerfect(Node root) {
		Node p = root;
		Node first = null;	// for a start of next level
		Node cur = null;	
		while (p != null) {
			if (first == null) {
				if (p.left != null) {
					first = p.left;
				} else if (p.right != null) {
					first = p.right;
				}
			}
			
			if (p.left != null) {
				if (cur != null) {
					cur.next = p.left;
				}
				cur = p.left;
			}
			
			if (p.right != null) {
				if (cur != null) {
					cur.next=p.right;
				}
				cur = p.right;
			}
			
			if (p.next != null) {
				p = p.next;
			} else {		// to the next level
				p = first;
				first = null;
				cur = null;
			}
		}
	}

	
	// Use BFS to link all the nodes, the end of a level connects
	// the begin of next level
	public static void populateAllNextPointer(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			Node e = queue.poll();
			queue.add(e.left);
			queue.add(e.right);
			e.next = queue.peek();
		}
	}
}

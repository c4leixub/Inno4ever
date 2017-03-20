package com.zeetcode.linklist;

import com.zeetcode.node.ListNode;

public class DeleteDuplicateNode {
	
	/**
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.
	 * For example,
	 * 
	 * Given 1->1->2, return 1->2.
	 * Given 1->1->2->3->3, return 1->2->3.
	 */
	public ListNode deleteDuplicates1(ListNode head) {
		ListNode dump = new ListNode(0);
		ListNode q = dump;
		
		ListNode p = head;
		while (p != null) {
			if (q == dump || q.val != p.val) {
				q.next = new ListNode(p.val);
				q = q.next;
			}
			p = p.next;
		}
		
		return dump.next;
	}
	
	/**
	 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
	 * leaving only distinct numbers from the original list.
	 * 
	 * For example, given 1->1->1->2->3, return 2->3.
	 */
	public ListNode deleteDuplicates2(ListNode head) {
		ListNode dump = new ListNode(0);
		ListNode q = dump;
		
		ListNode p = head;
		while (p != null) {
			ListNode next = p.next;
			if (next != null && next.val == p.val) {
			  while (next != null && next.val == p.val) {
			      next = next.next;
			  }
			} else {
			    q.next = new ListNode(p.val);
				q = q.next;
			}
			p = next;
		}
		
		return dump.next;
	}
}

package com.zeetcode.linklist;

import com.zeetcode.node.ListNode;

public class LinkListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null)	return false;

		ListNode slow = head;
		ListNode fast = head.next;

		while (slow != null && fast != null) {
			if (slow == fast)	return true;

			slow = slow.next;
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
		}

		return false;
	}
	
	public ListNode detectCycle(ListNode head) {
		if (head == null)	return null;
		
		ListNode slow = head;
		ListNode fast = head.next;
		
		while (slow != null && fast != null) {
			if (slow == fast) break;

			slow = slow.next;
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
		}
		
		if (fast == null)	return null;
		
		slow = head;
		fast = fast.next;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
		
    }
}

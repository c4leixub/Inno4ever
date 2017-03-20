package com.zeetcode.linklist;

import com.zeetcode.node.ListNode;

public class ReverseLinklist {
	public ListNode reverseList(ListNode head) {
		if (head == null)	return head;
		
		ListNode pre = null;
		ListNode cur = head;
		
		while (cur != null) {
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		
		return pre;
	}
	
	/**
	 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
	 * Given m, n satisfy the following condition:
	 * 1 ≤ m ≤ n ≤ length of list.
	 */
	public ListNode reverseList(ListNode head, int m, int n) {
		if (head == null)	return head;
				
		int i = 1;
		ListNode pre = null;
		ListNode cur = head;		
		while (i < m && cur != null) {
			pre = cur;
			cur = cur.next;
			i++;
		}
		
		if (cur == null)	return head;
		ListNode h = pre;
		
		pre = cur;
		cur = cur.next;
		i++;
		while (cur != null && i <= n) {
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
			i++;
		}
		
		if (h != null)	{
			h.next.next = cur;
			h.next = pre;
		} else {
			head.next = cur;
			return pre;
		}
		
		return head;
		
		
	}
}

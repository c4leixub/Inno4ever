package com.zeetcode.linklist;

import com.zeetcode.node.ListNode;

public class RemoveElement {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)	return null;
		
		ListNode fake = new ListNode(Integer.MIN_VALUE);
		
		ListNode pre = fake;
		ListNode cur = head;
		while (cur != null) {
			if (cur.val != val) {
				pre.next = cur;
				pre = cur;
			}
			
			cur = cur.next;
		}
		
		pre.next = cur;
		return fake.next;
	}
}

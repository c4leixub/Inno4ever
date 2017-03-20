package com.zeetcode.linklist;

import com.zeetcode.node.ListNode;

public class MergeTwoSortedLinklist {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)	return l2;
		if (l2 == null)	return l1;

		ListNode dump = new ListNode(0);
		ListNode p = dump;
		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {
				if (l1.val < l2.val) {
					p.next = new ListNode(l1.val);
					l1 = l1.next;
				} else if (l1.val > l2.val) {
					p.next = new ListNode(l2.val);
					l2 = l2.next;
				} else { // l1.val == l2.val
					p.next = new ListNode(l1.val);
					p.next.next = new ListNode(l2.val);
					l1 = l1.next;
					l2 = l2.next;
					p = p.next;
				}
			} else if (l1 != null) {
				p.next = new ListNode(l1.val);
				l1 = l1.next;
			} else { // l2 != null
				p.next = new ListNode(l2.val);
				l2 = l2.next;
			}

			p = p.next;
		}

		return dump.next;
	}
}

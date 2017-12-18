package com.zeetcode.aalk.linkedlist;

import com.zeetcode.node.ListNode;

public class MergeTwoSortedLinklist {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dump = new ListNode(0);
		ListNode p = dump, p1 = l1, p2 = l2;

		ListNode node;
		while (p1 != null && p2 != null) {
			if (p1.val <= p2.val) {
				node = new ListNode(p1.val);
				p1 = p1.next;
			} else {
				node = new ListNode(p2.val);
				p2 = p2.next;
			}

			p.next = node;
			p = p.next;
		}

		mergeListIfNotNull(p, p1);
		mergeListIfNotNull(p, p2);

		return dump.next;
	}

	private void mergeListIfNotNull(ListNode p, ListNode ps) {
		ListNode node;
		if (ps != null) {
			while (ps != null) {
				node = new ListNode(ps.val);
				ps = ps.next;

				p.next = node;
				p = p.next;
			}
		}
	}
}

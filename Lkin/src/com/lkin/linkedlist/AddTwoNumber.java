package com.lkin.linkedlist;

import com.common.structs.ListNode;

public class AddTwoNumber {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;

		int carry = 0, sum = 0, p1Val = 0, p2Val;
		ListNode p1 = l1, p2 = l2;
		while (p1 != null || p2 != null) {
			p1Val = p1 != null ? p1.val : 0;
			p2Val = p2 != null ? p2.val : 0;

			sum = p1Val + p2Val + carry;
			carry = sum / 10;

			p.next = new ListNode(sum % 10);
			p = p.next;

			if (p1 != null)
				p1 = p1.next;
			if (p2 != null)
				p2 = p2.next;
		}

		if (carry > 0) {
			p.next = new ListNode(carry);
		}

		return dummy.next;
	}
}

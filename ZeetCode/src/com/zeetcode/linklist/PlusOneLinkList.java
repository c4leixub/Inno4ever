package com.zeetcode.linklist;

import com.zeetcode.node.ListNode;

public class PlusOneLinkList {
	public ListNode plusOne(ListNode head) {
		int carry = plusOneHelp(head);
		if (carry != 0) {
			ListNode newHead = new ListNode(carry);
			newHead.next = head;
			return newHead;
		}

		return head;
	}

	public int plusOneHelp(ListNode node) {
		if (node.next == null) {
			int carry = (node.val + 1) / 10;
			node.val = (node.val + 1) % 10;
			return carry;
		}

		int carry = plusOneHelp(node.next);
		if (carry != 0) {
			int nextCarry = (node.val + carry) / 10;
			node.val = (node.val + carry) % 10;
			return nextCarry;
		}

		return 0;
	}
}

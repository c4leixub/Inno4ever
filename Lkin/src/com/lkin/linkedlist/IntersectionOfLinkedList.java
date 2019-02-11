package com.lkin.linkedlist;

import com.common.structs.ListNode;

public class IntersectionOfLinkedList {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)	return null;

		int lenA = getLength(headA), lenB = getLength(headB);
		if (lenA > lenB) {
			for (int i = 0; i < lenA - lenB; i++) headA = headA.next;
		} else {
			for (int i = 0; i < lenB - lenA; i++) headB = headB.next;
		}

		while (headA != null && headB != null && headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}

		if (headA != null && headB != null) {
			return headA;
		}

		return null;

		// ListNode a = headA, b = headB;
		// while (a != b) {
		//   a = (a != null) ? a.next : headB;
		//   b = (b != null) ? b.next : headA;
		// }
		// return a;
	}

	private int getLength(ListNode head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}
}

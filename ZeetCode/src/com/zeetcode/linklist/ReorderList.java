package com.zeetcode.linklist;

import com.zeetcode.node.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
 * L0→Ln→L1→Ln-1→L2→Ln-2→… Solution : Break list in the middle to two lists (use
 * fast & slow pointers) Reverse the order of the second list, then Merge two
 * list back together
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;

		// find list center
		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		// 'slow' is the middle node or the last element of the 1st part
		// split the list
		ListNode secondHead = slow.next;
		slow.next = null;

		// reverse second part of the list
		ListNode pre = null;
		ListNode cur = secondHead;
		while (cur != null) {
			ListNode t = cur.next;
			cur.next = pre;
			pre = cur;
			cur = t;
		}

		// combine two list
		ListNode p = head;
		ListNode q = pre;
		while (p != null) {
			ListNode np = p.next;
			ListNode nq = q != null ? q.next : null;

			p.next = q;
			if (q != null) {
				q.next = np;
			}

			p = np;
			q = nq;
		}
	}
}

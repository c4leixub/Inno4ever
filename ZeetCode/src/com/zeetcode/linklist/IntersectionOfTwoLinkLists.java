package com.zeetcode.linklist;

import com.zeetcode.node.ListNode;

/**	begin to intersect at node c1.
A:         a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3		*/
public class IntersectionOfTwoLinkLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int sizeA = 0, sizeB = 0;
		
		// get the size of list A and B
		ListNode p = headA;
		while (p != null) {
			p = p.next;
			sizeA++;
		}
		
		p = headB;
		while (p != null) {
			p = p.next;
			sizeB++;
		}
		
		// make p & q has equals amount of nodes to loop
		p = headA;
		ListNode q = headB;
		if (sizeA > sizeB) {
			while (sizeA > sizeB) {
				p = p.next;
				sizeA--;
			}
		} else {
			while (sizeB > sizeA) {
				q = q.next;
				sizeB--;
			}
		}
		
		// try to find the intersect node
		while (p != q) {
			p = p.next;
			q = q.next;
		}
		
		return p == q ? p : null;
	}
}

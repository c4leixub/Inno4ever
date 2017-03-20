package com.zeetcode.linklist;

import com.zeetcode.node.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at 
 * a time and return its modified list.
 * 
 * For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseKGroup {

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 1) return head;
		
		ListNode fake = new ListNode(0);
		fake.next = head;
		
		int i = 1;
		ListNode pre = fake;
		ListNode cur = head;
		while (cur != null) {
			if (i % k == 0) {
				pre = reverse(pre, cur.next);
				cur = pre.next;
			} else {
				cur = cur.next;
			}
			i++;
		}
		return fake.next;
	}
	
	/* 0->1->2->3->4->5->6
	 * |           |   
	 * pre        next
	 *
	 * after calling pre = reverse(pre, next)
	 * 
	 * 0->3->2->1->4->5->6
	 *          |  |
	 *          pre next 
	 */
	public ListNode reverse(ListNode pre, ListNode next) {
		ListNode last = pre.next;
        ListNode curr = last.next;
     
        while(curr != next){
            last.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = last.next;
        }
     
        return last; 
	}
}

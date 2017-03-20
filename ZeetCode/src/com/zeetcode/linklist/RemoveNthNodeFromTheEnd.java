package com.zeetcode.linklist;

import com.zeetcode.node.ListNode;

/**
 * Given a linked list, remove the nth node from 
 * the end of list and return its head.
 */
public class RemoveNthNodeFromTheEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p = head;
        while (n > 0) {
            if (p != null) {  
                p = p.next;
            } else {
                break;
            }
            n--;
        }
        
        ListNode pre = null;
        ListNode cur = head;
        while (p != null) {
            p = p.next;
            
            pre = cur;
            cur = cur.next;
        }
        
        if (pre == null) {
            return head.next;
        }
        
        pre.next = cur.next;
        return head;
	}
}

package com.zeetcode.linklist;

import com.zeetcode.node.ListNode;

public class SwapNodeInPairs {
	
	public ListNode swapPairs_ReplaceVal(ListNode head) {
		if (head == null)	return null;
		
		ListNode p = head;
		ListNode q = p.next;
		
		while (p != null && q != null) {
			int t = p.val;
			p.val = q.val;
			q.val = t;
			
			p = q.next;
			q = p != null? p.next : null;
		}
		
		return head;
	}
	
	public ListNode swapPairs_CreateNewNode(ListNode head) {
        if (head == null) return null;
        
        ListNode p1 = head;
        ListNode p2 = head;
        if (p2.next != null) {
            p2 = p2.next;
        } else {
            return new ListNode(p1.val);
        }
        
        ListNode dump = new ListNode(0);
        ListNode p = dump;
        ListNode next;
        while(p1 != null && p2 != null) {
            next = p2.next;
            
            p.next = new ListNode(p2.val);
            p.next.next = new ListNode(p1.val);
            p = p.next.next;
            
            p1 = next;
            if (p1 == null) {
                break;
            } else {
                p2 = p1.next;
                if (p2 == null) {
                    p.next = new ListNode(p1.val);
                    break;
                }
            }
        }
        
        return dump.next;
    }
}

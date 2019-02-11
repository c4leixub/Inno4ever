package com.lkin.linkedlist;

import com.common.structs.ListNode;

public class DetectCycle {
	public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            } else {
                return null;
            }
            
            slow = slow.next;
            
            if (fast == slow) {
                ListNode entry = head;
                while (slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        
        return null;
	}
}

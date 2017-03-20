package com.zeetcode.linklist;

import com.zeetcode.node.ListNode;

/** Given a list, rotate the list to the right by k places, where k is non-negative.
For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.	*/
public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (k > 0 && fast != null) {
            fast = fast.next;
            k--;
            if (fast == null) {
                fast = head;
            }
        }
        
        if (fast == null || slow == fast) {
            return head;
        }
        
        while (fast.next != null) { // Ex. slow = 3, fast = 5
            slow = slow.next;
            fast = fast.next;
        }
        
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        
        return newHead;
    }
}

package com.zeetcode.linklist;

import java.util.ArrayList;
import java.util.List;

import com.zeetcode.node.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * For example, given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		
		if (head == null)	return null;
		
		ListNode less = new ListNode(0);
        ListNode great = new ListNode(0);
        
        ListNode pl = less;
        ListNode pg = great;
        
        while (head != null) {
            if (head.val >= x ) {
                pg.next = new ListNode(head.val);
                pg = pg.next;
            } else {
                pl.next = new ListNode(head.val);
                pl = pl.next;
            }
            
            head = head.next;
        }
        
        if (less.next == null)   {
            return great.next;
        }
        
        pl.next = great.next;
        return less.next;
        
	}
}

package com.zeetcode.linklist;

import com.zeetcode.node.ListNode;

public class PalindromeLinklist {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)	return true;
		
		// move slow to the mid of the linklist
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;			
			slow = slow.next;
		}
		
		// start of the second half of the linklist
		ListNode second = slow.next;
		
		// reverse the second half of linklist
		ListNode pre = second;
		ListNode cur = second.next;
		while (cur != null) {
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		second.next = null;
		
		// compare two list
		ListNode p = head;
		ListNode q = pre;
		while (p != null && q != null) {
			if (p.val != q.val) return false;
			p = p.next;
			q = q.next;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		PalindromeLinklist p = new PalindromeLinklist();
		
		ListNode head = new ListNode(1);
		System.out.println(p.isPalindrome(head));
	}
}

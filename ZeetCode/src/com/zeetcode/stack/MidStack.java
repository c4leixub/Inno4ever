package com.zeetcode.stack;

import java.util.EmptyStackException;

import com.zeetcode.node.DoubleNode;

public class MidStack {
	
	private DoubleNode head = null;
	private DoubleNode mid = null;
	private int count = 0;
	
	public void push(int val) {
		DoubleNode newNode = new DoubleNode(val);
		newNode.next = head;
		
		count++;
		
		// change the mid pointer
		if (count == 1) {
			mid = newNode;
		} else {
			head.pre = newNode;
			if (count % 2 == 1) { // update mid if count is odd
				mid = mid.pre;
			}
		}
		
		head = newNode;
	}
	
	public int pop() {
		if (head == null) {
			throw new EmptyStackException();
		}
		
		DoubleNode tmp = head;
		count--;
		
		head = head.next;
		head.pre = null;
		if (count % 2 == 0) {
			mid = mid.next;
		}
		
		return tmp.val;
	}
	
	public int findMid() {
		if (mid == null) {
			throw new EmptyStackException();
		}
		
		return mid.val;
	}
	
	public int popMid() {
		if (mid == null) {
			throw new EmptyStackException();
		}
		
		int ret = mid.val;
		
		DoubleNode pre = mid.pre;
		DoubleNode next = mid.next;
		if (pre != null) {
			pre.next = next;
		} else {	// mid.pre is null, the only case is head == mid
			head = pre;
		}
		if (next != null) {
			next.pre = pre;
			mid = next;
		} else {
			mid = pre;
		}
		
		count--;
		return ret;
	}

	public int size() {
		return count;
	}
	
	public void print() {
		DoubleNode p = head;
		while (p != null) {
			if (p.pre == null) {
				System.out.print("null <-- ");
			}
			
			System.out.print(p);
			
			if (p.next == null) {
				System.out.print(" --> null");
			} else {
				System.out.print(" == ");
			}
			
			p = p.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		MidStack m = new MidStack();
		m.push(3);
		m.push(4);
		m.print();
		m.push(5);
		System.out.println(m.findMid());
		System.out.println(m.pop());
		m.print();
		System.out.println(m.findMid());
		System.out.println(m.popMid());
		System.out.println(m.popMid());
		
		m.print();
		System.out.println(m.size());
	}
	
}

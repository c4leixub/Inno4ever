package com.abb.abb.ds;

import java.util.NoSuchElementException;

public class QueueUsingFixArray {
	
	class ListNode {
		int[] data;
		int index;	// slot position to pop/peek
		int count;	// how many slot are in used
		ListNode next;
		
		public ListNode(int size) {
			data = new int[size];
			count = 0;	// how slot has use
			index = 0;
		}
		
		public void add(int x) {
			data[count] = x;
	        count++;
		}
		
		public int remove() {
			int val = data[index];
			data[index] = 0;
			index++;
	        return val;
		}
	}
	
	private int fixedSize;
	private ListNode head;
	private ListNode tail;
	private int size;
	
	public QueueUsingFixArray(int fixedSize) {
		this.fixedSize = fixedSize;
		head = new ListNode(fixedSize);
		tail = head;
		size = 0;
	}
	
	/** Push element x to the back of queue. */
    public void push(int x) {
        if (tail.count >= fixedSize) {
        	tail.next = new ListNode(fixedSize);
        	tail = tail.next;
        }
        
        tail.add(x);
        size++;
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	if (size == 0) {
    		throw new NoSuchElementException("The list is empty");
    	}
    	
        if (head.index >= fixedSize) {
        	head = head.next;
        }
        
        int val = head.remove();
        size--;
        return val;
    }
    
    /** Get the front element. */
    public int peek() {
    	if (head.index >= fixedSize) {
        	head = head.next;
        }
    	
    	return head.data[head.index];
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return size == 0;
    }
    
    public static void main(String[] args) {
    	QueueUsingFixArray q = new QueueUsingFixArray(2);
    	q.push(1);
    	q.push(2);
    	q.push(3);
    	q.push(4);
    	
    	q.pop();q.pop();q.pop();q.pop();
    	
    	try {
    		q.pop();
    	} catch (NoSuchElementException e) {
    		System.out.println("catch exception");
    	}
    	
    	q.push(5);
    	q.push(6);
    	q.pop();
    }
}

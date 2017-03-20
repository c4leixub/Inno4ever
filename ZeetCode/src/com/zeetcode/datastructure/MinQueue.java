package com.zeetcode.datastructure;

import java.util.Deque;
import java.util.LinkedList;

public class MinQueue {
    
	Deque<Integer> dequeue = new LinkedList<Integer>();
	Deque<Integer> minQ = new LinkedList<Integer>();
	
	public void push(int e) {
        dequeue.addLast(e);
        while (!minQ.isEmpty() && minQ.peekLast() > e) {
        		minQ.pollLast();
        }
        minQ.addLast(e);
    }

    public Integer pop() {
    		if (minQ.peek() == dequeue.peek()) {
    			minQ.poll();
    		}
    		return dequeue.pop();
    }

    public int min() {
    		return minQ.peek();
    }
}

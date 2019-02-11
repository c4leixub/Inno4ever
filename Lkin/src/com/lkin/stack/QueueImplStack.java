package com.lkin.stack;

import java.util.LinkedList;

public class QueueImplStack {
	
	private LinkedList<Integer> queue;

    public QueueImplStack() {
        queue = new LinkedList<Integer>();
    }

	public void push(int x) {
		queue.add(x);

		// add all the element at the back of the x
		int sz = queue.size();
		while (sz > 1) {
			queue.add(queue.remove());
			sz--;
		}
	}

	public int pop() {
		return queue.remove();
	}
	public int top() {
		return queue.peek();
	}
	public boolean empty() {
		return queue.isEmpty();
	}
}

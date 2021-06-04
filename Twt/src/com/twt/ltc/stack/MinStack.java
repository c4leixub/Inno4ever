package com.twt.ltc.stack;

import java.util.Stack;

public class MinStack {
	Stack<Integer> stack;
    Stack<Integer> min;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        min = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.add(x);
        if (min.isEmpty() || x <= min.peek()) {
            min.add(x);
        }
    }
    
    public void pop() {
        int v = stack.pop();
        if (!min.isEmpty() && v == min.peek()) {
            min.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

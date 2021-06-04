package com.twt.ltc.stack;

import java.util.Stack;

public interface MaxStack {

	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> maxStack = new Stack<Integer>();
	Stack<Integer> tempStack = new Stack<Integer>();
	
	default void push(int x) {
        stack.push(x);
        
        if (maxStack.isEmpty() || x >= maxStack.peek()) {
            maxStack.push(x);
        }
    }
    
	default int pop() {
        if (stack.peek() == peekMax()) {
            maxStack.pop();
        }
        return stack.pop();
    }
    
	default int top() {
        return stack.peek();
    }
    
	default int peekMax() {
        return maxStack.peek();
    }
    
	default int popMax() {
        while (!stack.isEmpty() && stack.peek() < maxStack.peek()) {
            tempStack.push(stack.pop());
        }
        
        int max = maxStack.pop();
        stack.pop();
        
        while (!tempStack.isEmpty()) {
            push(tempStack.pop());
        }
        
        return max;
    }
}

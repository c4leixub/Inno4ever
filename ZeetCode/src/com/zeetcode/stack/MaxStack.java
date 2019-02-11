package com.zeetcode.stack;

import java.util.Stack;

public class MaxStack {
	private Stack<Integer> stack;
    private Stack<Integer> maxStack;
    
    private Stack<Integer> tempStack;
    
    public MaxStack() {
        stack = new Stack<Integer>();
        maxStack = new Stack<Integer>();
        tempStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        
        if (maxStack.isEmpty() || x >= maxStack.peek()) {
            maxStack.push(x);
        }
    }
    
    public int pop() {
        if (top() == peekMax()) {
            maxStack.pop();
        }
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
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
    
    public static void main(String[] args) {
    	MaxStack m = new MaxStack();
    	m.push(5);
    	m.push(1);
    	m.push(5);
    	System.out.println(m.popMax());
    	
    }
}

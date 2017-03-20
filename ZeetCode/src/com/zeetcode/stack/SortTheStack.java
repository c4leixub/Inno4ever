package com.zeetcode.stack;

import java.util.Stack;

/**
 * Sort the stack in ascending order from bottom to top
 */
public class SortTheStack {

	public static void sort(Stack<Integer> stack) {
		if (stack.isEmpty()) return;
		
		Stack<Integer> tmp = new Stack<Integer>();
		while (!stack.isEmpty()) {
			tmp.push(stack.pop());
		}
		stack.push(tmp.pop());
		
		while(!tmp.isEmpty()) {
			Integer cur = tmp.pop();
			if (cur >= stack.peek()) {
				stack.push(cur);
			} else {
				while (!stack.isEmpty()) {
					Integer e = stack.pop();
					if (e > cur) {
						tmp.push(e);
					} else {
						break;
					}
				}
				stack.push(cur);
			}
		}
	}
}

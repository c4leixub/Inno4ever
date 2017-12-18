package com.zeetcode.aalk.stack;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation (POSTFIX).
Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class ReversePolishNotation {
	public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        int t;
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                t = stack.pop();
                stack.push(stack.pop() - t);
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                t = stack.pop();
                stack.push(stack.pop() / t);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        
        return stack.pop();
	}
}

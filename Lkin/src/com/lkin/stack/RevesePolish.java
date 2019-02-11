package com.lkin.stack;

import java.util.Stack;

public class RevesePolish {

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		String s;
		char c;
		int a, b;
		for (int i = 0; i < tokens.length; i++) {
			s = tokens[i];
			c = s.charAt(0);
			if (s.length() == 1 && !Character.isDigit(c)) {
				b = stack.pop();
				a = stack.pop();

				if (c == '+') {
					stack.push(a + b);
				} else if (c == '-') {
					stack.push(a - b);
				} else if (c == '*') {
					stack.push(a * b);
				} else {
					stack.push(a / b);
				}

			} else {
				stack.push(Integer.parseInt(s));
			}
		}

		return stack.pop();
	}
}

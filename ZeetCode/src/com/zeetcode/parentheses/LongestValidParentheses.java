package com.zeetcode.parentheses;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.
For "(()", the longest valid parentheses substring is "()", which has length = 2.
Another example is ")()())", where the longest valid parentheses substring is "()()", 
which has length = 4.
 */
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		// each element e in the stack is e[0]=pos i.e 0,1,2,...s.length-1
		// s[1] = 0, if charAt(i) is '(', otherwise 1
		Stack<int[]> stack = new Stack<int[]>();
		int result = 0;

		for (int i = 0; i <= s.length() - 1; i++) {
			char c = s.charAt(i);
			if (c == '(') {
				int[] a = { i, 0 };
				stack.push(a);
			} else {		// assume s only contains '(' and ')'
				if (stack.empty() || stack.peek()[1] == 1) {
					int[] a = { i, 1 };
					stack.push(a);
				} else {
					stack.pop();
					int currentLen = 0;
					if (stack.empty()) {
						currentLen = i + 1;
					} else {
						currentLen = i - stack.peek()[0];
					}
					result = Math.max(result, currentLen);
				}
			}
		}

		return result;
	}
	
	public static void main(String[] args) {
		LongestValidParentheses s = new LongestValidParentheses();
		System.out.println(s.longestValidParentheses(")()()"));
	}
}

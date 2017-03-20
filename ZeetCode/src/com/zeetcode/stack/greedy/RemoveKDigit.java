package com.zeetcode.stack.greedy;

import java.util.Stack;

public class RemoveKDigit {
	public String removeKdigits(String num, int k) {
		Stack<Character> stack = new Stack<Character>();
        char c;
        for (int i = 0; i < num.length(); i++) {
            c = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        // continue pop if we haven't finish remove k digit
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        // build the string
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        // remove leading zeros
        while (sb.length() > 0 && sb.charAt(sb.length()-1) == '0') {
            sb.deleteCharAt(sb.length()-1);
        }
        
        if (sb.length() == 0) {
            return "0";
        }
        
        sb.reverse();
        return sb.toString();
    }
}

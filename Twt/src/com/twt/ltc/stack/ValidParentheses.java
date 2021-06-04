package com.twt.ltc.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
	private static Map<Character, Character> closeToOpen = new HashMap<Character, Character>();
    static {
        closeToOpen.put(')', '(');
        closeToOpen.put('}', '{');
        closeToOpen.put(']', '[');
    };
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char c;
        int i = 0;
        while (i < s.length()) {
            c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                
                if (stack.pop() != closeToOpen.get(c)) {
                    return false;
                }
            }
            i++;
        }
        
        return stack.isEmpty();
    }
}

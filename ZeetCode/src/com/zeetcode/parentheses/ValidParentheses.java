package com.zeetcode.parentheses;

import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid. The brackets must close in the correct order, 
 * "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 */
public class ValidParentheses {

	public boolean isValid(String s) {
        
		Stack<Character> stack = new Stack<Character>();
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (map.containsKey(c)) {	// c == ( { [
				stack.push(c);
			} else if (map.containsValue(c)) {	// c == ) } ]
				if (stack.isEmpty()) {
					return false;
				} else {
					// the top of the stack must be the open of c
					// otherwise invalid bracket
					char k = stack.pop();
					if (map.get(k) != c ) {
						return false;
					}
				}
			}
		}
		
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
    }
}

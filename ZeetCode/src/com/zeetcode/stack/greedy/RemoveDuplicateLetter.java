package com.zeetcode.stack.greedy;

import java.util.Stack;

public class RemoveDuplicateLetter {
	public String removeDuplicateLetters(String s) {
		if (s == null || s.length() == 0)
			return s;

		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a'] += 1;
		}

		boolean[] visited = new boolean[26];
		Stack<Character> st = new Stack<Character>();
		for (char c : s.toCharArray()) {
			count[c - 'a']--;
			if (visited[c - 'a']) {
				continue;
			}

			// pop all char in the stack that is greater and set visit to false
			while (!st.isEmpty() && st.peek() > c && count[st.peek() - 'a'] > 0) {
				visited[st.pop() - 'a'] = false;
			}

			st.push(c);
			visited[c - 'a'] = true;
		}

		StringBuilder sb = new StringBuilder();
		while (!st.isEmpty()) {
			sb.append(st.pop());
		}

		return sb.reverse().toString();
	}
}

package com.zeetcode.string.decode;

import java.util.Stack;

/**
 * Encode a string with format k[encoded_string], print k time of
 * encoded_string. Ex, s = "3[a]2[bc]", return "aaabcbc". s = "3[a2[c]]", return
 * "accaccacc". s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {

	public String decodeStringTwoStack(String s) {
		Stack<Integer> counts = new Stack<>();
		Stack<String> result = new Stack<>();

		int count = 0;
		result.push("");

		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				count = count * 10 + (c - '0');
			} else if (c == '[') {
				counts.push(count);
				count = 0;
				result.push("");
			} else if (Character.isAlphabetic(c)) {
				result.push(result.pop() + c);
			} else if (c == ']') {
				String t = generateString(result.pop(), counts.pop());
				result.push(result.pop() + t);
			}
		}

		return result.pop();
	}

	public String decodeString(String s) {
		Stack<String> stack = new Stack<String>();

		int count = 0;
		StringBuilder sb;
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				count = count * 10 + (c - '0');
			} else if (c == '[') {
				stack.push(String.valueOf(count));
				count = 0;
				stack.push("[");
			} else if (Character.isAlphabetic(c)) {
				stack.push(String.valueOf(c));
			} else if (c == ']') {
				sb = new StringBuilder();
				while (!"[".equals(stack.peek())) {
					sb.append(stack.pop());
				}
				stack.pop(); // remove the "["
				int k = Integer.parseInt(stack.pop());
				String t = generateString(sb.toString(), k);
				stack.push(t);
			}
		}

		sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
	}

	public String generateString(String s, int k) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < k; i++) {
			res.append(s);
		}
		return res.toString();
	}

	public static void main(String[] args) {
		DecodeString d = new DecodeString();
		System.out.println(d.decodeStringTwoStack("3[a]2[bc]"));
		System.out.println(d.decodeString("3[a2[c]]"));
	}
}

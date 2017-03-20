package com.zeetcode.string;

import java.util.Stack;

public class LongestAbsoluteFilePath {

	public int lengthLongestPath(String input) {
		if (input == null || input.length() == 0)
			return 0;

		int max = 0;
		Stack<Node> stack = new Stack<Node>();

		String[] arr = input.split("\n");
		for (int i = 0; i < arr.length; i++) {
			String s = arr[i];

			int count = 0; // counter of \t
			while (count < s.length() - 1) {
				if (s.charAt(count) == '\t') {
					count++;
				} else {
					break;
				}
			}

			while (!stack.isEmpty() && count <= stack.peek().level) {
				stack.pop();
			}

			if (s.contains(".")) {
				if (stack.isEmpty()) {
					max = Math.max(max, s.length() - count);
				} else {
					max = Math.max(max, stack.peek().length + s.length()
							- count);
				}
			} else {
				if (stack.isEmpty()) {
					stack.push(new Node(count, s.length() - count + 1));
				} else {
					stack.push(new Node(count, stack.peek().length + s.length()
							- count + 1));
				}
			}
		}

		return max;
	}

	public class Node {
		int level;
		int length;

		public Node(int lev, int len) {
			this.level = lev;
			this.length = len;
		}
	}

	public static void main(String[] args) {
		LongestAbsoluteFilePath p = new LongestAbsoluteFilePath();
		System.out
				.println(p
						.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
	}
}

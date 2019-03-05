package com.abb.calculator;

import java.util.LinkedList;

public class BasicCalculator2 {
	public int calculate(String s) {
		LinkedList<Integer> numList = new LinkedList<Integer>();
		LinkedList<Character> operatorList = new LinkedList<Character>();

		boolean hasMultiply = false;
		boolean hasDiv = false;
		StringBuilder sb = new StringBuilder();

		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (c == '+' || c == '-' || c == '*' || c == '/') {
				int num = Integer.parseInt(sb.toString());
				sb = new StringBuilder();

				if (hasMultiply) {
					numList.add(numList.pollLast() * num);
					hasMultiply = false;
				} else if (hasDiv) {
					numList.add(numList.pollLast() / num);
					hasDiv = false;
				} else {
					numList.add(num);
				}

				if (c == '+' || c == '-') {
					operatorList.add(c);
				} else if (c == '*') {
					hasMultiply = true;
				} else if (c == '/') {
					hasDiv = true;
				}
			} else if (!Character.isWhitespace(c)) {
				sb.append(c);
			}
		}

		if (sb.length() > 0) {
			int num = Integer.parseInt(sb.toString());
			if (hasMultiply) {
				numList.add(numList.pollLast() * num);
				hasMultiply = false;
			} else if (hasDiv) {
				numList.add(numList.pollLast() / num);
				hasDiv = false;
			} else {
				numList.add(num);
			}
		}

		Integer result = numList.pop();
		while (!numList.isEmpty() && !operatorList.isEmpty()) {
			c = operatorList.pop();
			if (c == '+') {
				result += numList.pop();
			} else if (c == '-') {
				result -= numList.pop();
			}
		}

		return result;
	}
}

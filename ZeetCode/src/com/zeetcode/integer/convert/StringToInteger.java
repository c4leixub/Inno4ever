package com.zeetcode.integer.convert;

public class StringToInteger {
	public int myAtoi(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}

		int i = 0;
		while (i < str.length() && Character.isWhitespace(str.charAt(i))) {
			i++;
		}

		if (i >= str.length()) {
			return 0;
		}

		int m = 1;
		if (str.charAt(i) == '+' || str.charAt(i) == '-') {
			if (str.charAt(i) == '-') {
				m = -1;
			}
			i++;
		}

		if (i >= str.length()) {
			return 0;
		}

		double re = 0.0;
		while (i < str.length()) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9') {
				break;
			}

			re = re * 10 + (str.charAt(i) - '0');
			i++;
		}

		re = m * re;

		// handle max and min
		if (re > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (re < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		return (int) re;
	}
}

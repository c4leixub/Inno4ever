package com.zeetcode.dynamicprogramming;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26
 * 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
 * "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 *
 */
public class DecodeWay {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}

		int[] t = new int[s.length() + 1];
		t[0] = 1;

		// if(s.charAt(0)!='0')
		if (isValid(s.substring(0, 1)))
			t[1] = 1;
		else
			t[1] = 0;

		for (int i = 2; i <= s.length(); i++) {
			if (isValid(s.substring(i - 1, i))) {
				t[i] += t[i - 1];
			}

			if (isValid(s.substring(i - 2, i))) {
				t[i] += t[i - 2];
			}
		}

		return t[s.length()];
	}

	private boolean isValid(String s) {
		if (s.charAt(0) == '0')
			return false;
		int value = Integer.parseInt(s);
		return 1 <= value && value <= 26;
	}

	public static void main(String[] args) {
		DecodeWay d = new DecodeWay();
		System.out.println(d.numDecodings("2121"));
	}
}

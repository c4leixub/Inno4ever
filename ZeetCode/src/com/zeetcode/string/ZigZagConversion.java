package com.zeetcode.string;

/**
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string text, int nRows); convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (s == null || s.length() <= 1 || numRows == 1) {
			return s;
		}

		StringBuilder[] sbs = new StringBuilder[numRows];
		for (int i = 0; i < sbs.length; i++) {
			sbs[i] = new StringBuilder();
		}

		int k = 0, m = 1;
		for (int i = 0; i < s.length(); i++) {
			sbs[k].append(s.charAt(i));

			if (k == numRows - 1) {
				m = -1;
			} else if (k == 0) {
				m = 1;
			}

			k += m;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sbs.length; i++) {
			sb.append(sbs[i].toString());
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		ZigZagConversion z = new ZigZagConversion();
		System.out.println(z.convert(s, 3));
	}
}

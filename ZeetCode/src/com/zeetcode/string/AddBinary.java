package com.zeetcode.string;

public class AddBinary {
	public String addBinary(String a, String b) {
		if (a == null && b == null)
			return null;
		if (a == null)
			return b;
		if (b == null)
			return a;

		int i = a.length() - 1;
		int j = b.length() - 1;

		String re = "";

		int plus = 0;
		while (i >= 0 && j >= 0) {
			int k1 = a.charAt(i) - 48;
			int k2 = b.charAt(j) - 48;
			re = ((k1 + k2 + plus) % 2) + re;
			plus = (k1 + k2 + plus) / 2;

			i--;
			j--;
		}

		while (i >= 0) {
			int k1 = a.charAt(i) - 48;
			re = ((k1 + plus) % 2) + re;
			plus = (k1 + plus) / 2;
			i--;
		}

		while (j >= 0) {
			int k2 = b.charAt(j) - 48;
			re = ((k2 + plus) % 2) + re;
			plus = (k2 + plus) / 2;
			j--;
		}

		if (plus != 0) {
			re = plus + re;
		}

		return re;
	}
}

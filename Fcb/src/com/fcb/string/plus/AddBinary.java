package com.fcb.string.plus;

public class AddBinary {
	public String addBinary(String a, String b) {

		char[] res = new char[Math.max(a.length(), b.length())];
		int k = res.length - 1;

		int i = a.length() - 1, j = b.length() - 1, sum, carry = 0;
		while (i >= 0 && j >= 0) {
			sum = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
			res[k] = (char) (sum % 2 + '0');
			carry = sum / 2;

			i--;
			j--;
			k--;
		}

		while (i >= 0) {
			sum = (a.charAt(i) - '0') + carry;
			res[k] = (char) (sum % 2 + '0');
			carry = sum / 2;

			i--;
			k--;
		}

		while (j >= 0) {
			sum = (b.charAt(j) - '0') + carry;
			res[k] = (char) (sum % 2 + '0');
			carry = sum / 2;

			j--;
			k--;
		}

		if (carry != 0) {
			return "1" + new String(res);
		}

		return new String(res);
	}
}

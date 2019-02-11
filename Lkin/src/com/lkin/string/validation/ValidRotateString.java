package com.lkin.string.validation;

public class ValidRotateString {
	public boolean rotateString(String A, String B) {
		if (A.length() != B.length()) {
			return false;
		}
		if (A.equals(B)) {
			return true;
		}

		int len = A.length();
		for (int s = 1; s < len; s++) {

			int i = 0;
			while (i < len) {
				if (A.charAt(i) != B.charAt((i + s) % len)) {
					break;
				}
				i++;
			}

			if (i == len) {
				return true;
			}
		}

		return false;
	}
}
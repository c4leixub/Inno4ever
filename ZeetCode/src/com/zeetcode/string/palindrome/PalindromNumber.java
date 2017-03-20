package com.zeetcode.string.palindrome;

public class PalindromNumber {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;

		int d = 1;
		while (x / d >= 10) {
			d *= 10;
		}

		while (x != 0) {
			int r = x % 10;
			int f = x / d;
			if (r != f)
				return false;

			x = x % d / 10;
			d /= 100;
		}

		return true;
	}

	public boolean isPalindromeLong(long number) {
		if (number < 0) {
			return false;
		}

		long d = 1;
		while (number / d >= 10) {
			d *= 10;
		}

		long s, e;
		while (number > 0) {
			s = number / d;
			e = number % 10;
			if (s != e) {
				return false;
			}

			number = (number % d) / 10;
			d /= 100;
		}

		return true;
	}
	
	public static void main(String[] args) {
		PalindromNumber n = new PalindromNumber();
		System.out.println(n.isPalindromeLong(222));
	}
}

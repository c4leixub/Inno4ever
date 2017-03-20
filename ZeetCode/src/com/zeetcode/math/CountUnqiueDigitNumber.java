package com.zeetcode.math;

public class CountUnqiueDigitNumber {
	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 10;
		}
		if (n >= 11) {
			return countNumbersWithUniqueDigits(10);
		}

		int nine = 9;
		int result = 9;
		int i = 0;
		while (i + 1 < n) {
			result = result * (nine - i);
			i++;
		}

		return result + countNumbersWithUniqueDigits(n - 1);
	}

	public static void main(String[] args) {
		CountUnqiueDigitNumber c = new CountUnqiueDigitNumber();
		System.out.println(c.countNumbersWithUniqueDigits(2));
	}
}

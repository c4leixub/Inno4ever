package com.zeetcode.array.counting;

/**
 * Given a integer n, count all numbers with unique digits, x, where 0 ≤ x < 10 ^ n.
 *
 */
public class CountNumbersWithUniqueDigits {
	
	public int countNumbersWithUniqueDigits(int n) {
		if (n < 0) {
			countNumbersWithUniqueDigits(0 - n);
		}
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
		
		return result + countNumbersWithUniqueDigits(n-1);
    }
	
	public static void main(String[] args) {
		CountNumbersWithUniqueDigits o = new CountNumbersWithUniqueDigits();
		System.out.println(o.countNumbersWithUniqueDigits(2));
		System.out.println(o.countNumbersWithUniqueDigits(3));
	}
}

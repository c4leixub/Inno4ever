package com.zeetcode.string.palindrome;

import java.util.HashMap;

/*
 * Find the length of a maximum palindrome subset in an array.
 * For example: in a, b, d, a the maximum palindrome subset is a, b, a
 * and the answer is 3
 */
public class LongPalindromSubSet {
	public int maximumPalindromeSubsetLength(char[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		
		if (array.length == 1) {
			return 1;
		}
		
		HashMap<Character, Integer> m = new HashMap<Character, Integer>();
		for (char c : array) {
			if (m.containsKey(c)) {
				m.put(c, m.get(c) + 1);
			} else {
				m.put(c, 1);
			}
		}
		
		int maxOdd = 0;
		int totalEven = 0;
		for (Character c : m.keySet()) {
			if (m.get(c) % 2 == 0) {
				totalEven += m.get(c);
			} else {
				maxOdd = Math.max(maxOdd, m.get(c));
			}
		}
		
		if (maxOdd != 0) return maxOdd+totalEven;
		
		return totalEven;
	}
	
	public static void main(String[] args) {
		char[] a = new char[] {'a', 'b', 'd', 'a'};
		LongPalindromSubSet s = new LongPalindromSubSet();
		System.out.println(s.maximumPalindromeSubsetLength(a));
	}
}

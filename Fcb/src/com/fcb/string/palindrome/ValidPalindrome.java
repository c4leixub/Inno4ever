package com.fcb.string.palindrome;

public class ValidPalindrome {

	/**
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 * Example 1: Input: "A man, a plan, a canal: Panama" Output: true
	 */
	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {

			while (i < s.length() && i < j && !Character.isLetterOrDigit(s.charAt(i))) {
				i++;
			}

			while (j >= 0 && i < j && !Character.isLetterOrDigit(s.charAt(j))) {
				j--;
			}

			if (i > j) {
				break;
			}

			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
				return false;
			}

			i++;
			j--;
		}

		return true;
	}

	// Given a non-empty string s, you may delete at most one character. Judge
	// whether you can make it a palindrome.
	public boolean validPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return helper(s, i + 1, j) || helper(s, i, j - 1);
			}

			i++;
			j--;
		}

		return true;
	}

	private boolean helper(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}

			i++;
			j--;
		}

		return true;
	}
}

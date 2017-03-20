package com.zeetcode.string.palindrome;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases. For example,
 * "A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a
 * palindrome.
 *
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			boolean b1 = isAlphanumeric(s.charAt(i));
			boolean b2 = isAlphanumeric(s.charAt(j));
			if (b1 && b2) {
				if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
					return false;
				}
				i++;
				j--;
			} else {
				if (!b1) {
					i++;
				}
				if (!b2) {
					j--;
				}
			}
		}

		return true;
	}

	public boolean isAlphanumeric(char c) {
		return Character.isDigit(c) || Character.isAlphabetic(c);
	}
}

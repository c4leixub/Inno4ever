package com.zeetcode.string.palindrome;

public class ValidPalindrome {
	/** Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases. For example, "A man, a plan, a
	 * canal: Panama" is a palindrome. "race a car" is not a palindrome.
	 */
	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (Character.isLetterOrDigit(s.charAt(i)) && Character.isLetterOrDigit(s.charAt(j))) {

				if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
					i++;
					j--;
				} else {
					return false;
				}

			} else {
				if (!Character.isLetterOrDigit(s.charAt(i))) {
					i++;
				}

				if (!Character.isLetterOrDigit(s.charAt(j))) {
					j--;
				}
			}
		}
		return true;
	}

	/** Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
	 */
	public boolean validPalindrome(String s) {
		int i = 0, j = s.length() - 1;

		int[] indexes = new int[2];
		if (validPalindrome(s, i, j, indexes)) {
			return true;
		}

		i = indexes[0];
		j = indexes[1];
		return validPalindrome(s, i + 1, j, indexes) || validPalindrome(s, i, j - 1, indexes);
	}
	private boolean validPalindrome(String s, int i, int j, int[] indexes) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				indexes[0] = i;
				indexes[1] = j;
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}

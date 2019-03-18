package com.lkin.dp;

/**
 * 
 * In computer science, edit distance is a way of quantifying how dissimilar two
 * strings (e.g., words) are to one another by counting the minimum number of
 * operations required to transform one string into the other.
 * 
 * There are three operations permitted on a word: replace, delete, insert. For
 * example, the edit distance between "a" and "b" is 1, the edit distance
 * between "abc" and "def" is 3. This post analyzes how to calculate edit
 * distance by using dynamic programming.
 *
 */
public class EditDistance {
	public static int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();

		// len1+1, len2+1, because finally return dp[len1][len2]
		int[][] dp = new int[len1 + 1][len2 + 1];

		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}

		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}

		// iterate though, and check last char
		for (int i = 0; i < len1; i++) {
			char c1 = word1.charAt(i);
			for (int j = 0; j < len2; j++) {
				char c2 = word2.charAt(j);

				// if last two chars equal
				if (c1 == c2) {
					// update dp value for +1 length
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					int replace = dp[i][j] + 1;
					int insert = dp[i][j + 1] + 1;
					int delete = dp[i + 1][j] + 1;

					int min = replace > insert ? insert : replace;
					min = delete > min ? min : delete;
					dp[i + 1][j + 1] = min;
				}
			}
		}

		return dp[len1][len2];
	}
	
	public static void main(String[] args) {
		System.out.println(EditDistance.minDistance("cat", "dog"));
	}

	//	Given two strings S and T, determine if they are both one
	// edit distance apart.
	public boolean isOneEditDistance(String s, String t) {
		if (s == null || t == null)
			return false;

		int m = s.length();
		int n = t.length();

		if (Math.abs(m - n) > 1) {
			return false;
		}

		int i = 0;
		int j = 0;
		int count = 0;

		while (i < m && j < n) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
				j++;
			} else {
				count++;
				if (count > 1)
					return false;

				if (m > n) {
					i++;
				} else if (m < n) {
					j++;
				} else {
					i++;
					j++;
				}
			}
		}

		if (i < m || j < n) {
			count++;
		}

		if (count == 1)
			return true;

		return false;
	}
}

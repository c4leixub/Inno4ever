package com.twt.string;

import java.util.*;

/**
 * Given a string s, return the maximum number of ocurrences of any substring
 * under the following rules:
 * 
 * The number of unique characters in the substring must be less than or equal
 * to maxLetters.
 * 
 * The substring size must be between minSize and maxSize inclusive.
 */
public class MaxSubstringOccurrence {

	public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
		int ans = 0;
		Map<String, Integer> freq = new HashMap<>();

		String sub;
		for (int i = 0; i < s.length() - minSize + 1; i++) {
			sub = s.substring(i, i + minSize);
			if (freq.containsKey(sub) || countUnique(sub) <= maxLetters)
				freq.put(sub, freq.getOrDefault(sub, 0) + 1);
		}

		for (Integer value : freq.values()) {
			ans = Math.max(ans, value);
		}

		return ans;
	}

	private int countUnique(String s) {
		boolean[] v = new boolean[26];
		int unique = 0;

		for (int i = 0; i < s.length(); i++) {
			if (!v[s.charAt(i) - 'a']) {
				unique++;
				v[s.charAt(i) - 'a'] = true;
			}
		}
		return unique;
	}
}

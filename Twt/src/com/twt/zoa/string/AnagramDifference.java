package com.twt.zoa.string;

public class AnagramDifference {
	public int anagram(String s) {
		if (s.length() % 2 != 0) {
			return -1;
		}

		return annagramDiff(s.substring(0, s.length() / 2), s.substring(s.length() / 2));
	}

	public int annagramDiff(String s1, String s2) {
		int res = 0;

		int[] count = new int[26];
		char c;
		for (int i = 0; i < s1.length(); i++) {
			c = s1.charAt(i);
			count[c - 'a']++;
		}

		for (int i = 0; i < s2.length(); i++) {
			c = s2.charAt(i);
			count[c - 'a']--;
			if (count[c - 'a'] < 0) {
				res++;
			}
		}

		return res;
	}
}

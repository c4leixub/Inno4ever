package com.fcb.hashing;

public class VerifyAlienDictionary {
	public boolean isAlienSorted(String[] words, String order) {

		if (words == null || words.length <= 1) {
			return true;
		}

		// build a rank char -> index in order
		int index;
		int[] rank = new int[26];
		for (int i = 0; i < order.length(); i++) {
			index = order.charAt(i) - 'a';
			rank[index] = i;
		}

		int len;
		String pre = words[0], cur;
		boolean sorted;
		for (int i = 1; i < words.length; i++) {
			cur = words[i];

			sorted = false;
			len = Math.min(pre.length(), cur.length());
			for (int j = 0; j < len; j++) {
				if (rank[pre.charAt(j) - 'a'] > rank[cur.charAt(j) - 'a']) {
					return false;
				} else if (rank[pre.charAt(j) - 'a'] == rank[cur.charAt(j) - 'a']) {
					continue;
				} else {
					// found char in pre with less rank than char in cur, sorted
					sorted = true;
					break;
				}
			}

			// this check is to deal with case like compare "apple" and "app"
			if (!sorted && pre.length() > cur.length()) {
				return false;
			}

			pre = words[i];
		}

		return true;
	}
}

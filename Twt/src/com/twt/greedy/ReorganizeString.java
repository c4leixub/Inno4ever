package com.twt.greedy;

import java.util.*;

public class ReorganizeString {
	public String reorganizeString(String S) {
		int[] count = new int[26];
		char c;
		for (int i = 0; i < S.length(); i++) {
			c = S.charAt(i);
			count[c - 'a']++;
		}

		PriorityQueue<Character> pq = new PriorityQueue<>(
				(a, b) -> count[a - 'a'] == count[b - 'a'] ? a - b : count[b - 'a'] - count[a - 'a']);

		for (int i = 0; i < 26; i++) {
			if (count[i] > 0) {
				if (count[i] > (S.length() + 1) / 2)
					return "";
				pq.add((char) ('a' + i));
			}
		}

		Character c1, c2;
		StringBuilder res = new StringBuilder();
		while (pq.size() >= 2) {
			c1 = pq.poll();
			c2 = pq.poll();

			res.append(c1);
			res.append(c2);
			count[c1 - 'a']--;
			count[c2 - 'a']--;

			if (count[c1 - 'a'] > 0) {
				pq.add(c1);
			}
			if (count[c2 - 'a'] > 0) {
				pq.add(c2);
			}
		}

		if (pq.size() > 0)
			res.append(pq.poll());
		return res.toString();
	}

	public String reorganizeStringFaster(String S) {
		int N = S.length();
		int[] counts = new int[26];
		for (char c : S.toCharArray())
			counts[c - 'a'] += 100;
		for (int i = 0; i < 26; ++i)
			counts[i] += i;
		// Encoded counts[i] = 100*(actual count) + (i)
		Arrays.sort(counts);

		char[] ans = new char[N];
		int t = 1;
		for (int code : counts) {
			int ct = code / 100;
			char ch = (char) ('a' + (code % 100));

			if (ct > (N + 1) / 2)
				return "";

			for (int i = 0; i < ct; ++i) {
				if (t >= N)
					t = 0;
				ans[t] = ch;
				t += 2;
			}
		}

		return String.valueOf(ans);
	}
}

package com.zeetcode.aafb.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {
	public boolean isWordBreak(String s, List<String> wordDict) {
		if (s == null || wordDict == null || wordDict.size() == 0) {
			return false;
		}

		Set<String> wordSet = new HashSet<String>();
		for (String w : wordDict) {
			wordSet.add(w);
		}

		if (s.isEmpty() && wordSet.contains("")) {
			return true;
		}

		int n = s.length();
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;

		String word;
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < i; j++) {
				word = s.substring(j, i);
				if (dp[j] && wordSet.contains(word)) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[n];
	}

	public List<String> wordBreak(String s, List<String> wordDict) {
		if (s == null || wordDict == null || wordDict.size() == 0) {
			return new ArrayList<String>();
		}

		Set<String> wordSet = new HashSet<String>();
		for (String w : wordDict) {
			wordSet.add(w);
		}

		Map<String, List<String>> map = new HashMap<String, List<String>>();
		return wordBreakHelper(s, wordSet, map);
	}

	public List<String> wordBreakHelper(String s, Set<String> wordSet, Map<String, List<String>> map) {

		if (map.containsKey(s)) {
			return map.get(s);
		}

		List<String> result = new ArrayList<String>();
		if (s.length() == 0) {
			return result;
		}

		for (int i = 0; i <= s.length(); i++) {
			String subfix = s.substring(0, i);

			if (wordSet.contains(subfix)) {
				if (i == s.length()) {
					result.add(subfix);
				} else {
					String prefix = s.substring(i);
					List<String> tmp = wordBreakHelper(prefix, wordSet, map);
					for (String w : tmp) {
						result.add(subfix + " " + w);
					}
				}
			}
		}

		map.put(s, result);
		return result;
	}
}

package com.zeetcode.backtracking.dp;

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

		boolean[] dp = new boolean[s.length()];
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				String sub = s.substring(j, i);
				if (wordSet.contains(sub)) {
					if (j == 0 || dp[j - 1]) {
						dp[i - 1] = true;
					}
				}
			}
		}

		return dp[s.length() - 1];
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

	public List<String> wordBreakHelper(String s, Set<String> wordSet,
			Map<String, List<String>> map) {

		if (map.containsKey(s))
			return map.get(s);

		List<String> result = new ArrayList<String>();
		if (s.length() <= 0) {
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

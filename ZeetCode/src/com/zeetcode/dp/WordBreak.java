package com.zeetcode.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
		if (s == null || wordDict == null) {
			return false;
		}
		int n = s.length();
		if (n == 0 && wordDict.contains("")) {
			return true;
		}
		boolean[] dp = new boolean[n];
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				String sub = s.substring(j, i);
				if (wordDict.contains(sub)) {
					if (j == 0 || dp[j - 1] == true) {
						dp[i - 1] = true;
					}
				}
			}
		}
		return dp[n - 1];
	}

	public List<String> wordBreak2(String s, Set<String> wordDict) {
		ArrayList<String>[] pos = new ArrayList[s.length() + 1];
		pos[0] = new ArrayList<String>();

		for (int i = 0; i < s.length(); i++) {
			if (pos[i] != null) {
				for (int j = i + 1; j <= s.length(); j++) {
					String sub = s.substring(i, j);
					if (wordDict.contains(sub)) {
						if (pos[j] == null) {
							ArrayList<String> list = new ArrayList<String>();
							list.add(sub);
							pos[j] = list;
						} else {
							pos[j].add(sub);
						}

					}
				}
			}
		}

		if (pos[s.length()] == null) {
			return new ArrayList<String>();
		} else {
			ArrayList<String> result = new ArrayList<String>();
			dfs(pos, result, "", s.length());
			return result;
		}
	}

	public void dfs(ArrayList<String>[] pos, ArrayList<String> result,
			String curr, int i) {
		if (i == 0) {
			result.add(curr.trim());
			return;
		}

		for (String s : pos[i]) {
			String combined = s + " " + curr;
			dfs(pos, result, combined, i - s.length());
		}
	}
}

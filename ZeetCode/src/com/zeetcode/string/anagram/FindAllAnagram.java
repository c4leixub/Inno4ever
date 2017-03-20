package com.zeetcode.string.anagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagram {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();

		Map<Character, Integer> map = buildMap(p);

		char c;
		int match = 0;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0) {
					match++;
				}
			}

			if (i >= p.length()) {
				c = s.charAt(i - p.length());
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
					if (map.get(c) == 1) {
						match--;
					}
				}
			}

			if (match == map.size()) {
				result.add(i - p.length() + 1);
			}
		}

		return result;
	}

	public Map<Character, Integer> buildMap(String s) {
		Map<Character, Integer> charCounts = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
		}
		return charCounts;
	}
}

package com.goo.string;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	public boolean wordPattern(String pattern, String str) {

		Map<Character, String> map = new HashMap<Character, String>();
		StringBuilder sb;
		int j = 0;
		char c;
		for (int i = 0; i < pattern.length(); i++) {
			c = pattern.charAt(i);

			sb = new StringBuilder();
			while (j < str.length() && str.charAt(j) != ' ') {
				sb.append(str.charAt(j));
				j++;
			}

			if (map.containsKey(c)) {
				if (!map.get(c).equals(sb.toString())) {
					return false;
				} else {
					map.put(c, sb.toString());
				}
			}

			j++;
		}

		return true;
	}
	
	public static void main(String[] args) {
		WordPattern w = new WordPattern();
		w.wordPattern("abba", "dog cat cat dog");
	}
}

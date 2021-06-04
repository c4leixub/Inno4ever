package com.twt.slidewindow;

import java.util.HashMap;

public class LongestSubstringWithDistinctCharacter {

	public int lenOfLongestSubStrWithKDistnctChar(String s, int k) {
		int max = 0;
		HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
		int left = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (charCount.containsKey(c)) {
				charCount.put(c, charCount.get(c)+1);
			} else {
				charCount.put(c, 1);
			}
			
			if (charCount.size() > k) {
				max = Math.max(max, i-left);
				
				while (charCount.size() > k) {
					char t = s.charAt(left);
					int count = charCount.get(t);
					if (count > 1) {
						charCount.put(t, count-1);
					} else {
						charCount.remove(t);
					}
					
					left++;
				}
			}
		}
		
		max = Math.max(max, s.length()-left);
		
		return max;
	}
}

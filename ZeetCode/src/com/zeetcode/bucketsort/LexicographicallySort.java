package com.zeetcode.bucketsort;

import java.util.HashMap;

/**
 * Give a string containing 'a' to 'z', sort lexicographically. Example " bbdda" -­ > "abbdd"
 */
public class LexicographicallySort {
	public String sort(String s) {
		if (s == null || s.length() <= 1)	return s;
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		StringBuffer sb = new StringBuffer();
		char c = 'a';
		while (c <= 'z' && !map.isEmpty()) {
			if (map.containsKey(c)) {
				for (int i = 0; i < map.get(c); i++) {
					sb.append(c);
				}
				map.remove(c);
			}
			c = (char) (c + 1);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		LexicographicallySort s = new LexicographicallySort();
		System.out.println(s.sort("bbdda"));
	}
}

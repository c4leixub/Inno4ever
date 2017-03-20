package com.zeetcode.string;

import java.util.Arrays;
import java.util.HashMap;

public class StrStrImpl {
	// aka haystack.indexOf(needle);
	public int strStr(String haystack, String needle) {
		if ("".equals(needle)) {
			return 0;
		}

		if (haystack.length() < needle.length()) {
			return -1;
		}

		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				int j = 1;
				while (j < needle.length()) {
					if (haystack.charAt(i + j) != needle.charAt(j)) {
						break;
					}
					j++;
				}

				if (j == needle.length())
					return i;
			}
		}

		return -1;
	}

	public int strStrP(String haystack, String needle) {
		if ("".equals(needle)) {
			return 0;
		}

		if (haystack.length() < needle.length()) {
			return -1;
		}
		
		HashMap<Character, Integer> needleMap = new HashMap<Character, Integer>();
		Character c;
		for (int i = 0; i < needle.length(); i++) {
			c = needle.charAt(i);
			if (needleMap.containsKey(c)) {
				needleMap.put(c, needleMap.get(c)+1);
			} else {
				needleMap.put(c, 1);
			}
		}
		
		HashMap<Character, Integer> tempMap;
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			tempMap = new HashMap<Character, Integer>();
			for (int j = 0; j < needle.length(); j++) {
				c = haystack.charAt(i+j);
				if (tempMap.containsKey(c)) {
					tempMap.put(c, tempMap.get(c)+1);
				} else {
					tempMap.put(c, 1);
				}
			}
			
			if (needleMap.equals(tempMap)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		String haystack = "hello";
		String needle = "ho";
		
		StrStrImpl str = new StrStrImpl();
		System.out.println(str.strStrP(haystack, needle));
	}
}

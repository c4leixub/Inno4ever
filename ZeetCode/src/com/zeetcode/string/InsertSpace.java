package com.zeetcode.string;

import java.util.HashMap;

public class InsertSpace {
	public String insertString(String s, int k) {
		if (s == null || s.length() == 0)	return "";
		if (k < 0) return s;
		
		StringBuffer sb = new StringBuffer();
		
		//	the value in map is the pos in new string before next key appear
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			// we see a new 'char', add '_'s
			while (map.containsKey(c) && j <= map.get(c) + k ) {
				sb.append('_');
				j++;
			}
			
			sb.append(c);
			map.put(c, j);	// update the pos of c
			j++;
		}
		
		return sb.toString();
	}
	
	public String getKSpace(int k) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < k; i++) {
			sb.append('_');
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		InsertSpace s = new InsertSpace();
		System.out.println(s.insertString("123456246124", 6));
		System.out.println(s.insertString("123456246124", 0));
		System.out.println(s.insertString("123456", 1));
	}
}

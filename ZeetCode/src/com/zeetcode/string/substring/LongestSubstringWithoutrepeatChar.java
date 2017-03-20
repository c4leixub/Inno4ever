package com.zeetcode.string.substring;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutrepeatChar {
	public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        Set<Character> set = new HashSet<Character>();
        
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
            } else {
                max = Math.max(max, i - left);
                while (set.contains(c)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(c);
            }
        }
        
        return Math.max(max, s.length()-left);
    }
	
	public static void main(String[] args) {
		String s = "abcabcbb";
		LongestSubstringWithoutrepeatChar a = new LongestSubstringWithoutrepeatChar();
		System.out.println(a.lengthOfLongestSubstring(s));
	}
}

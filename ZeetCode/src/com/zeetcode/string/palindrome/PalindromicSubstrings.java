package com.zeetcode.string.palindrome;

public class PalindromicSubstrings {
	public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += countSubstrings(s, i);
        }
        return res;
    }
    
    private int countSubstrings(String s, int i) {
        int c = 0, left = i, right = i;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            c++;
            left--;
            right++;
        }
        
        left = i; right = i+1;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            c++;
            left--;
            right++;
        }
        
        return c;
    }
}

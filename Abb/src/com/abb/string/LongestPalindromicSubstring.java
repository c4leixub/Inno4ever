package com.abb.string;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int maxLen = 0, start = -1, end = -1;
        int[] t;
        for (int i = 0; i < s.length(); i++) {
            t = getPalindromeIndexes(s, i, i);
            if (t[1] + 1 - t[0] >= maxLen) {
                maxLen = t[1] + 1 - t[0];
                start = t[0];
                end = t[1] + 1;
            }
            
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i+1)) {
                t = getPalindromeIndexes(s, i, i+1);
                if (t[1] + 1 - t[0] >= maxLen) {
                    maxLen = t[1] + 1 - t[0];
                    start = t[0];
                    end = t[1] + 1;
                }
            }
        }
        
        return s.substring(start, end);
    }
    
    private int[] getPalindromeIndexes(String s, int left, int right) {        
        int[] result = new int[] {left, right};
        
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            result[0] = left;
            result[1] = right;
            
            left--;
            right++;
        }
        
        return result;
    }
}

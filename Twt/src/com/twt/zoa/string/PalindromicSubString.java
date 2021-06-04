package com.twt.zoa.string;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * @author tonylei
 *
 */
public class PalindromicSubString {
	public int countSubstrings(String s) {
        
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPalindrome(s, i, i);

            if (i+1 <= s.length() - 1 && s.charAt(i) == s.charAt(i+1)) {
                count += countPalindrome(s, i, i+1);
            }
        }
        
        return count;
    }
    
    private int countPalindrome(String s, int x, int y) {
        int count = 0;
		while (x >= 0 && y <= s.length() - 1) {
            if (s.charAt(x) == s.charAt(y)) {
                count++;
            } else {
                break;
            }
            
            x--;
            y++;
        }
        
        return count; 
    }
}

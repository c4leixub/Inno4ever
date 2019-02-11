package com.lkin.string.substring;

import java.util.HashSet;
import java.util.Set;

public class MaxSubstringWithoutRepeatChar {
	public int lengthOfLongestSubstring(String s) {
        int max = 0, i = 0, j = 0, n = s.length();
        Set<Character> set = new HashSet<Character>();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        
        return max;
    }
}

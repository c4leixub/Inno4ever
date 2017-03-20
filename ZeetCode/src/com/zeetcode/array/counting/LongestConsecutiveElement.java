package com.zeetcode.array.counting;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveElement {
	public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int max = 1;

        for (int e : nums) {
            set.add(e);
        }
        
        for (int e : nums) {
            int left = e - 1;
            int right = e + 1;
            int count = 1;
            
            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }
            
            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }
            
            max = Math.max(count, max);
        }
        
        return max;
    }
}

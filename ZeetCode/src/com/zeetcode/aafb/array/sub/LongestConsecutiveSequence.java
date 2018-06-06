package com.zeetcode.aafb.array.sub;

import java.util.HashSet;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * Input: [100, 4, 200, 1, 3, 2] Output: 4 Explanation: The longest consecutive
 * elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
            return 0;
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        for (int n : nums) {
            set.add(n);
        }
        
        int maxLength = 1;
        for (int n : nums) {
            if (!set.contains(n-1)) {
                int currentStreak = 1, currentNum = n;
                while (set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                
                maxLength = Math.max(maxLength, currentStreak);
            }
        }
        
        return maxLength;
	}
}

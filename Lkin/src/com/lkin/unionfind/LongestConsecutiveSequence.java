package com.lkin.unionfind;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		Set<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			s.add(nums[i]);
		}

		int max = 1;
		for (int i = 0; i < nums.length; i++) {
			if (!s.contains(nums[i])) {
				continue;
			}

			s.remove(nums[i]);
			int count = 1;
			int left = nums[i] - 1;
			while (s.contains(left)) {
				count++;
				s.remove(left);
				left--;
			}

			int right = nums[i] + 1;
			while (s.contains(right)) {
				count++;
				s.remove(right);
				right++;
			}

			max = Math.max(max, count);
		}

		return max;
	}
}

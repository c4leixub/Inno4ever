package com.zeetcode.aafb.array.sub;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with
 * equal number of 0 and 1.
 * 
 * Example 1: Input: [0,1] Output: 2 Explanation: [0, 1] is the longest
 * contiguous subarray with equal number of 0 and 1.
 * Example 2: Input: [0,1,0]
 * Output: 2 Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray
 * with equal number of 0 and 1.
 */
public class ContiguousArrayZeroOne {

	public int findMaxLength(int[] nums) {
		int max = 0, sum = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				sum += 1;
			} else {
				sum -= 1;
			}

			if (map.containsKey(sum)) {
				max = Math.max(max, i - map.get(sum));
			} else {
				map.put(sum, i);
			}
		}

		return max;
	}
}

package com.zeetcode.aafb.array.sub;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of non-negative numbers and a target integer k, write a function
 * to check if the array has a continuous subarray of size at least 2 that sums
 * up to the multiple of k, that is, sums up to n*k where n is also an integer.
 * 
 * Example 1: Input: [23, 2, 4, 6, 7], k=6 Output: True Explanation: Because [2,
 * 4] is a continuous subarray of size 2 and sums up to 6. Example 2: Input:
 * [23, 2, 6, 4, 7], k=6 Output: True Explanation: Because [23, 2, 6, 4, 7] is
 * an continuous subarray of size 5 and sums up to 42.
 */
public class ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
		int sum = 0;

		// key is sum value is # of subarray equals k
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int key = (k == 0) ? sum : (sum % k);
			if (map.containsKey(key)) {
				if (i - map.get(key) > 1)
					return true;
			} else {
				map.put(key, i);
			}
		}

		return false;
	}
}

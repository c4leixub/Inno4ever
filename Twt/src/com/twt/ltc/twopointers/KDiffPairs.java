package com.twt.ltc.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the number of unique
 * k-diff pairs in the array.
 * 
 * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are
 * true:
 * 
 * 0 <= i, j < nums.length; i != j; |nums[i] - nums[j]| == k
 */
public class KDiffPairs {

	public int findPairs(int[] nums, int k) {
		Arrays.sort(nums);

		int i = 0, j = 1, result = 0;
		while (i < nums.length && j < nums.length) {
			if (i == j || nums[j] - nums[i] < k) {
				j++;
			} else if (nums[j] - nums[i] > k) {
				i++;
			} else {
				result++;
				i++;
				while (i < nums.length && nums[i] == nums[i - 1]) {
					i++;
				}
			}
		}
		return result;
	}

	public int findPairsHash(int[] nums, int k) {
		int result = 0;

		Map<Integer, Integer> counts = new HashMap<>();
		for (int num : nums) {
			counts.put(num, counts.getOrDefault(num, 0) + 1);
		}

		int num, count;
		for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
			num = entry.getKey();
			count = entry.getValue();

			if (k > 0 && counts.containsKey(num + k)) {
				result++;
			} else if (k == 0 && count > 1) {
				result++;
			}
		}

		return result;
	}

}

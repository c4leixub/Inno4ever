package com.zeetcode.aafb.dp;

/**
 * In a given array nums of positive integers, find three non-overlapping
 * subarrays with maximum sum.
 * 
 * Each subarray will be of size k, and we want to maximize the sum of all 3*k
 * entries.
 * 
 * Return the result as a list of indices representing the starting position of
 * each interval (0-indexed). If there are multiple answers, return the
 * lexicographically smallest one.
 * 
 * Example: Input: [1,2,1,2,6,7,5,1], 2 Output: [0, 3, 5] Explanation: Subarrays
 * [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5]. We could
 * have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically
 * larger.
 */
public class MaximiumThreeNonOverlapSubarray {
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int n = nums.length, mx = Integer.MIN_VALUE;
		int[] sums = new int[n + 1], left = new int[n], right = new int[n], res = null;

		sums[0] = 0;
		for (int i = 0; i < n; i++) {
			sums[i + 1] = sums[i] + nums[i];
			left[i] = 0;
			right[i] = n - k;
		}

		int i = k, total = sums[k] - sums[0];
		while (i < n) {
			if (sums[i + 1] - sums[i + 1 - k] > total) {
				left[i] = i + 1 - k;
				total = sums[i + 1] - sums[i + 1 - k];
			} else {
				left[i] = left[i - 1];
			}
			i++;
		}

		i = n - 1 - k;
		total = sums[n] - sums[n - k];
		while (i >= 0) {
			if (sums[i + k] - sums[i] >= total) {
				right[i] = i;
				total = sums[i + k] - sums[i];
			} else {
				right[i] = right[i + 1];
			}
			i--;
		}

		for (i = k; i <= n - 2 * k; ++i) {
			int l = left[i - 1], r = right[i + k];
			total = (sums[i + k] - sums[i]) + (sums[l + k] - sums[l]) + (sums[r + k] - sums[r]);
			if (mx < total) {
				mx = total;
				res = new int[] { l, i, r };
			}
		}

		return res;
	}

}

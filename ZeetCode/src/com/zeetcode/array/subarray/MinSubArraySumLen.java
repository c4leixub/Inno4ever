package com.zeetcode.array.subarray;

/**
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a subarray of which the sum ≥ s. If there isn't one, return
 * 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has
 * the minimal length of 2 under the problem constraint.
 */
public class MinSubArraySumLen {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 1)
			return 0;

		int result = nums.length;

		int start = 0;
		int sum = 0;
		int i = 0;
		boolean exists = false;

		while (i <= nums.length) {
			if (sum >= s) {
				exists = true; // mark if there exists such a subarray
				if (start == i - 1) {
					return 1;
				}

				result = Math.min(result, i - start);
				sum = sum - nums[start];
				start++;

			} else {
				if (i == nums.length)
					break;
				sum = sum + nums[i];
				i++;
			}
		}

		if (exists) {
			return result;
		} else {
			return 0;
		}
	}

	public int minSubArrayLenBinarySearch(int s, int[] nums) {
		int n = nums.length, res = n + 1;
		int[] sums = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			sums[i] = sums[i - 1] + nums[i - 1];
		}

		for (int i = 0; i < n + 1; i++) {
			int right = searchRight(i + 1, n, sums[i] + s, sums);
			if (right == n + 1)
				break;
			if (res > right - i)
				res = right - i;
		}
		return res == n + 1 ? 0 : res;
	}

	private int searchRight(int left, int right, int key, int[] sums) {
		while (left <= right) {
			int mid = (left + right) / 2;
			if (sums[mid] >= key) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

}

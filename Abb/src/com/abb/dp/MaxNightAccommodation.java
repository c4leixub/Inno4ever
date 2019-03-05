package com.abb.dp;

public class MaxNightAccommodation {

	/**
	 * Given a set of numbers in an array which represent number of consecutive days
	 * of AirBnB reservation requested, as a host, pick the sequence which maximizes
	 * the number of days of occupancy, at the same time, leaving at least 1 day gap
	 * in between bookings for cleaning. Problem reduces to finding max-sum of
	 * non-consecutive array elements.
	 */
	public int max(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		if (nums.length == 1)
			return nums[0];

		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}

		return dp[nums.length - 1];
	}
}

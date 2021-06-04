package com.twt.ltc.math;

/**
 * You are given an integer array nums and two integers limit and goal. The
 * array nums has an interesting property that abs(nums[i]) <= limit.
 * 
 * Return the minimum number of elements you need to add to make the sum of the
 * array equal to goal. The array must maintain its property that abs(nums[i])
 * <= limit.
 * 
 * Note that abs(x) equals x if x >= 0, and -x otherwise.
 */
public class MinElementsAddFormGivenSum {
	public int minElements(int[] nums, int limit, int goal) {
		long sum = 0;
		for (int num : nums) {
			sum += num;
		}

		long diff = Math.abs(goal - sum);
		
		/*
		 * now the goal is to decrease diff to 0 by subtract number with abs(number) <= limit
		 * and the best is keep subtracting limit and can be done (diff/limit) times
		 * if diff % limit > 0, we subtract a number with abs(number) <= limit, therefore +1
		 */
		return (int) ((diff / limit) + (diff % limit > 0 ? 1 : 0));

		/*
		 * long a = (Math.abs(goal - sum) + limit - 1) / limit;
		 * return (int) a;
		 */
	}
}

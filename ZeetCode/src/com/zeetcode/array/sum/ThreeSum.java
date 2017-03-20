package com.zeetcode.array.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	/**
	 * Given an array S of n integers, are there elements a, b, c in S such that
	 * a + b + c = 0? Find all unique triplets in the array which gives the sum
	 * of zero.
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (nums == null || nums.length < 3)
			return result;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			// if nums[i] == nums[i-1], we already examine nums[i] in previous loop
			if (i != 0 && nums[i] == nums[i - 1])
				continue;

			int j = i + 1;
			int k = nums.length - 1;

			while (j < k) {
				if (nums[i] + nums[j] + nums[k] == 0) {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					k--;
					j++;

					// handle duplicate here
					while (j < k && nums[j] == nums[j - 1])
						j++;
					while (j < k && nums[k] == nums[k + 1])
						k--;
				} else if (nums[i] + nums[j] + nums[k] > 0) {
					k--;
				} else {
					j++;
				}
			}
		}

		return result;
	}

	/**
	 * Given an array S of n integers, find three integers in S such that the sum is closest to a given target. 
	 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
	 */
	public int threeSumClosest(int[] nums, int target) {
		if (nums == null) {
			return 0;
		} else if (nums.length < 3) {
			int result = 0;
			for (int a : nums) {
				result += a;
			}
			return result;
		}
		
		Arrays.sort(nums);

		int min_diff = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				
				if (target == sum) {
					return target;
				}
				
				if (Math.abs(target - sum) < min_diff) {
					min_diff = Math.abs(target - sum);
					result = sum;
				}
				
				if (target > sum) {
					j++;
				} else {	// target < sum
					k--;
				}
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		ThreeSum s = new ThreeSum();

		int[] nums = new int[] { -1, 0, 1, 2, -1, -4 }; // {-4,-1,-1,0,1,2}
		System.out.println(s.threeSum(nums));

		nums = new int[] { -2, -2, 0, 0, 2, 2 };
		System.out.println(s.threeSum(nums));
		
		nums = new int[] {-1, 2, 1, -4,};
		System.out.println(s.threeSumClosest(nums, 1));
	}
}

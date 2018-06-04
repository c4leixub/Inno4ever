package com.zeetcode.array.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	/**
	 * Given an array S of n integers, are there elements a, b, c in S such that a +
	 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (nums == null || nums.length < 3)
			return result;

		Arrays.sort(nums);
		int sum, j, k, t;
		for (int i = 0; i < nums.length; i++) {
			// if nums[i] == nums[i-1], we already examine nums[i] in previous loop
			if (i != 0 && nums[i - 1] == nums[i])
				continue;

			j = i + 1;
			k = nums.length - 1;
			while (j < k) {
				sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));

					// handle duplicates
					t = nums[j];
					while (j < k && nums[j] == t)
						j++;

					t = nums[k];
					while (j < k && nums[k] == t)
						k--;
				} else if (sum > 0) {
					k--;
				} else {
					j++;
				}
			}
		}
		return result;
	}

	/**
	 * Given an array S of n integers, find three integers in S such that the sum is
	 * closest to a given target. Return the sum of the three integers. You may
	 * assume that each input would have exactly one solution.
	 */
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
        int res = 0, min_diff = Integer.MAX_VALUE;
        int sum, k, j;
        for (int i = 0; i <= nums.length-3; i++) {
        	// handle duplicates
            if (i != 0 && nums[i-1] == nums[i]) continue;
            
            j = i + 1; k = nums.length - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                
                if (Math.abs(target - sum) < min_diff) {
					min_diff = Math.abs(target - sum);
					res = sum;
				}
                
                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
	}

	public static void main(String[] args) {
		ThreeSum s = new ThreeSum();

		int[] nums = new int[] { -1, 0, 1, 2, -1, -4 }; // {-4,-1,-1,0,1,2}
		System.out.println(s.threeSum(nums));

		nums = new int[] { -2, -2, 0, 0, 2, 2 };
		System.out.println(s.threeSum(nums));

		nums = new int[] { -1, 2, 1, -4, };
		System.out.println(s.threeSumClosest(nums, 1));
	}
}

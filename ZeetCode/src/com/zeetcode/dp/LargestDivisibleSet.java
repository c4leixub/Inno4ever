package com.zeetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSet {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		if (nums.length == 0)
			return new ArrayList<Integer>();
		// nums has at least one element
		int n = nums.length;
		Arrays.sort(nums);
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int[] parent = new int[n];
		Arrays.fill(parent, -1);// 当parent数组中某数为-1时，表示这个数自己是一个集合
		int max = 1, max_index = -1;
		for (int i = 1; i < n; i++) { // calculate dp[i]
			for (int j = i - 1; j >= 0; j--) { // i > j
				if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) { 
					dp[i] = dp[j] + 1;
					parent[i] = j;
					if (dp[i] > max) {
						max = dp[i];
						max_index = i;
					}
				}
			}
		}
		return genResult(nums, parent, max_index);
	}

	public List<Integer> genResult(int[] nums, int[] parent, int max_index) {
		List<Integer> result = new ArrayList<>();
		if (max_index == -1) { // 每个数都是单独成集合，都不能合并
			result.add(nums[0]); // 随便输出一个数，这里选第一个
			return result;
		}
		int iter = max_index;
		while (iter != -1) {
			result.add(nums[iter]);
			iter = parent[iter];
		}
		return result;
	}
}

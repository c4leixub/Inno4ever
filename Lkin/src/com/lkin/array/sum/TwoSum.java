package com.lkin.array.sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int d;
		Map<Integer, Integer> visited = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			d = target - nums[i];
			if (visited.containsKey(d)) {
				return new int[] { visited.get(d), i };
			} else {
				visited.put(nums[i], i);
			}
		}

		return new int[] { -1, -1 };
	}
}

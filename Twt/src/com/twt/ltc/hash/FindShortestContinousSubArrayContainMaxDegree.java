package com.twt.ltc.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this
 * array is defined as the maximum frequency of any one of its elements.
 * 
 * Your task is to find the smallest possible length of a (contiguous) subarray
 * of nums, that has the same degree as nums.
 */
public class FindShortestContinousSubArrayContainMaxDegree {
	public int findShortestSubArray(int[] nums) {

		// degree is number of a char repeat in array
		int degree = 1;	
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> indexes;
		for (int i = 0; i < nums.length; i++) {
			indexes = map.get(nums[i]);
			if (indexes == null) {
				indexes = new ArrayList<>();
				map.put(nums[i], indexes);
			}
			indexes.add(i);
			degree = Math.max(degree, indexes.size());
		}

		int min = nums.length, length;
		for (Integer key : map.keySet()) {
			indexes = map.get(key);
			if (indexes.size() == degree) {
				length = indexes.get(indexes.size() - 1) - indexes.get(0) + 1;
				min = Math.min(min, length);
			}

		}
		return min;
	}
}

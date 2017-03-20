package com.zeetcode.array.counting;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 */
public class FindSingletonInArray {

	public int singleNumber(int[] nums) {
		Arrays.sort(nums);

		int i = 0;
		while (i < nums.length) {
			if (i == nums.length - 1) {
				return nums[i];
			}

			if (nums[i] == nums[i + 1]) {
				i += 2;
			} else {
				return nums[i];
			}
		}

		return Integer.MIN_VALUE;
	}

	public int[] twoSingleNumber(int[] nums) {
		int[] result = new int[2];
		HashSet<Integer> set = new HashSet<Integer>();

		for (int a : nums) {
			if (set.contains(a)) {
				set.remove(a);
			} else {
				set.add(a);
			}
		}

		if (set.size() == 2) {
			int i = 0;
			for (Integer e : set) {
				result[i] = e;
				i++;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 1, 3, 2, 5 };
		FindSingletonInArray f = new FindSingletonInArray();
		System.out.println(f.twoSingleNumber(nums)[0]);
		System.out.println(f.twoSingleNumber(nums)[1]);
	}

}

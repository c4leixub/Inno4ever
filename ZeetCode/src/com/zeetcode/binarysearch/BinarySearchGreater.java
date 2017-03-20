package com.zeetcode.binarysearch;

public class BinarySearchGreater {
	public int searchForGreater(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}


		if (target >= nums[nums.length-1] || target < nums[0]) {
			return nums[0];
		}
		

		int lo = 0;
		int hi = nums.length-1;

		while (lo + 1 < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] == target) {
				lo = mid + 1;
			} else if (nums[mid] > target) {
				hi = mid;
			} else if (nums[mid] < target) {
				lo = mid + 1;
			}
		}

		if (nums[lo] > target) {
			return nums[lo];
		} else if (nums[hi] > target) {
			return nums[hi];
		}

		return nums[0];
	}
}

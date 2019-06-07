package com.lkin.binarysearch;

public class FindMinInSortedRotatedArray {
	public int findMin(int[] nums) {
		if (nums.length == 1)
			return nums[0];

		int left = 0;
		int right = nums.length - 1;

		// not rotated
		if (nums[left] < nums[right])
			return nums[left];

		while (left <= right) {
			if (right - left == 1) {
				return nums[right];
			}

			int m = left + (right - left) / 2;

			if (nums[m] > nums[right])
				left = m;
			else
				right = m;
		}

		return nums[left];
	}

	public int findMinRecursive(int[] nums) {
		if (nums.length == 1)
			return nums[0];

		int left = 0;
		int right = nums.length - 1;

		// not rotated
		if (nums[left] < nums[right])
			return nums[left];

		return findMinRecursive(nums, left, right);
	}
	private int findMinRecursive(int[] nums, int left, int right) {
		if (left > right)
			return nums[left];

		if (right - left == 1) {
			return nums[right];
		}

		int m = left + (right - left) / 2;
		if (nums[m] > nums[right]) {
			left = m;
		} else {
			right = m;
		}

		return findMinRecursive(nums, left, right);
	}

	public int findMinWithDuplicate(int[] nums) {
		if (nums.length == 1)
			return nums[0];

		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			if (right - left == 1) {
				return Math.min(nums[left], nums[right]);
			}

			if (nums[left] < nums[right]) {
				return nums[left];
			}

			int m = left + (right - left) / 2;

			if (nums[right] == nums[left]) {
				left++;
			} else if (nums[m] >= nums[left]) {
				left = m;
			} else {
				right = m;
			}
		}

		return nums[left];
	}

	public int findMinWithDuplicateRecursive(int[] num) {
		return findMin(num, 0, num.length - 1);
	}
	private int findMin(int[] num, int left, int right) {
		if (right == left) {
			return num[left];
		}
		if (right == left + 1) {
			return Math.min(num[left], num[right]);
		}
		// 3 3 1 3 3 3

		int middle = (right - left) / 2 + left;
		// already sorted
		if (num[right] > num[left]) {
			return num[left];
			// right shift one
		} else if (num[right] == num[left]) {
			return findMin(num, left + 1, right);
			// go right
		} else if (num[middle] >= num[left]) {
			return findMin(num, middle, right);
			// go left
		} else {
			return findMin(num, left, middle);
		}
	}

}

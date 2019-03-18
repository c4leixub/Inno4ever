package com.lkin.binarysearch;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1. 
 */
public class FindSortedRotateArray {
	
	// Iterative solution where nums contains no duplicate
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (target == nums[mid])
				return mid;

			if (nums[left] <= nums[mid]) {
				if (nums[left] <= target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}

		return -1;
	}

	// Recursive solution where nums contains no duplicate
	// Call search(nums, 0, nums.length-1, target)
	public int search(int[] nums, int left, int right, int target) {
		if (left > right)
			return -1;
		int mid = left + (right - left) / 2;

		if (target == nums[mid])
			return mid;

		if (nums[left] <= nums[mid]) {
			if (nums[left] <= target && target < nums[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		} else {
			if (nums[mid] < target && target <= nums[right]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return search(nums, left, right, target);
	}

	// Method for array contains duplicate
	public boolean searchWithDup(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target)
				return true;

			if (nums[left] < nums[mid]) {
				if (nums[left] <= target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else if (nums[left] > nums[mid]) {
				if (nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				left++;
			}
		}

		return false;
	}

}

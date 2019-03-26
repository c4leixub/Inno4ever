package com.abb.abb;

import java.util.Arrays;

public class WiggleSort {

	/**
	 * Given an unsorted array nums, reorder it in-place such that nums[0] <=
	 * nums[1] >= nums[2] <= nums[3]....
	 * 
	 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6,
	 * 2, 5, 3, 4].
	 */
	public void wiggleSort(int[] nums) {
		/*
		 * Arrays.sort(nums); for (int i = 2; i < nums.length; i += 2) { int tmp =
		 * nums[i - 1]; nums[i - 1] = nums[i]; nums[i] = tmp; }
		 */

		for (int i = 1; i < nums.length; i++) {
			if ((i % 2 == 1 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] > nums[i - 1])) {
				int tmp = nums[i - 1];
				nums[i - 1] = nums[i];
				nums[i] = tmp;
			}
		}
	}

	/**
	 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] >
	 * nums[2] < nums[3]....
	 */
	public void wiggleSortWithGreater(int[] nums) {
		int[] tmp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			tmp[i] = nums[i];
		}

		Arrays.sort(tmp);

		int i = 0, j = nums.length - 1, m = i + (j - i) / 2;
		while (i < nums.length) {
			if (i % 2 == 1) {
				nums[i] = tmp[j];
				j--;
			} else {
				nums[i] = tmp[m];
				m--;
			}
			i++;
		}

	}

	public static void main(String[] args) {
		int i = 0;
		System.out.println(i & 1);
		i = 1;
		System.out.println(i & 1);
	}
}

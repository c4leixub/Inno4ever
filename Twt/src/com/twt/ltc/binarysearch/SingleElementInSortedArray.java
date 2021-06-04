package com.twt.ltc.binarysearch;

/**
 * You are given a sorted array consisting of only integers where every element
 * appears exactly twice, except for one element which appears exactly once.
 * Find this single element that appears only once.
 */
public class SingleElementInSortedArray {
	public int singleNonDuplicate(int[] nums) {
		boolean halfIsEven;
		int s = 0, e = nums.length - 1, m;
		while (s < e) {
			m = s + (e - s) / 2;
			halfIsEven = (e - m) % 2 == 0;
			if (nums[m] == nums[m + 1]) {
				if (halfIsEven) {
					s = m + 2;
				} else {
					e = m - 1;
				}
			} else if (nums[m - 1] == nums[m]) {
				if (halfIsEven) {
					e = m - 2;
				} else {
					s = m + 1;
				}
			} else {
				return nums[m];
			}
		}
		return nums[s];
	}
}

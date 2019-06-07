package com.zeetcode.array.elementInterchange;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}

		// scan from right to left, find the 1st element that is less than its previous
		// one
		int p = 0;
		int i = nums.length - 2;
		while (i >= 0) {
			if (nums[i] < nums[i + 1]) {
				p = i;
				break;
			}
			i--;
		}

		// scan from right to left, find the first element that is greater than nums[p]
		int q = 0;
		i = nums.length - 1;
		while (i >= 0) {
			if (nums[i] > nums[p]) {
				q = i;
				break;
			}
			i--;
		}

		if (p == 0 && q == 0) {
			reverse(nums, 0, nums.length - 1);
			return;
		}

		// swap p and q
		int t = nums[p];
		nums[p] = nums[q];
		nums[q] = t;

		// reverse elements [p+1, nums.length]
		if (p < nums.length - 1) {
			reverse(nums, p + 1, nums.length - 1);
		}
	}

	private void reverse(int[] nums, int s, int e) {
		while (s < e) {
			int t = nums[s];
			nums[s] = nums[e];
			nums[e] = t;

			s++;
			e--;
		}
	}
}

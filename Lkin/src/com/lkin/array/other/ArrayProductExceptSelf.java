package com.lkin.array.other;

public class ArrayProductExceptSelf {

	public int[] productExceptSelfWithoutDiv(int[] nums) {
		// suppose nums = {2, 4, 6, 8}
		int[] result = new int[nums.length];

		// this will make result = {4*6*8, 6*8, 8, 1}
		result[nums.length - 1] = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			result[i] = result[i + 1] * nums[i + 1];
		}

		// multiply left on each result[i] and keep
		// increament left by (left * num[i])
		int left = 1;
		for (int i = 0; i < nums.length; i++) {
			result[i] = result[i] * left;
			left = left * nums[i];
		}

		return result;
	}
}

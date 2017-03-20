package com.zeetcode.array.product;

public class ArrayProductExceptSelf {

	public int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length < 2) {
			return nums;
		}

		int product = 1;
		for (int i = 0; i < nums.length; i++) {
			product = product * nums[i];
		}

		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			result[i] = product / nums[i];
		}

		return result;
	}

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
	
	public static void main(String[] args) {
		ArrayProductExceptSelf a = new ArrayProductExceptSelf();
		
		int[] nums = new int[] {2, 4, 6, 8};
		int[] re = a.productExceptSelfWithoutDiv(nums);
		
		for (int k : re) {
			System.out.println(k);
		}
	}
}

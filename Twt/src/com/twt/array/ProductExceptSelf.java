package com.twt.array;

public class ProductExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		
		// ex. nums = {2, 3, 4, 5}
		
		res[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}
		// res = {1, 2, 2*3, 2*3*4}

		int t = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			res[i] = res[i] * t;
			t = t * nums[i];
		}
		//	t  = 3*4*5, 	4*5, 	5
		// res = {1, 		2, 		2*3*5, 2*3*4}

		return res;
	}
}

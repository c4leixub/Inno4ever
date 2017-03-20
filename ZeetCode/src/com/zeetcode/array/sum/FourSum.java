package com.zeetcode.array.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if (nums == null || nums.length < 4)
			return result;
		
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length - 3; i++) {
			if (i != 0 && nums[i] == nums[i-1])
				continue;
			
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j != i+1 && nums[j] == nums[j-1])
					continue;
				
				int x = j + 1;
				int y = nums.length - 1;
				
				while (x < y) {
					int sum = nums[i] + nums[j] + nums[x] + nums[y];
					if (sum == target) {
						result.add(Arrays.asList(nums[i], nums[j], nums[x], nums[y]));
						x++;
						y--;

						// handle duplicate here
						while (x < y && nums[x] == nums[x - 1])
							x++;
						while (x < y && nums[y] == nums[y + 1])
							y--;
						
					} else if (sum > target) {
						y--;
					} else {
						x++;
					}
				}
			}

		}

		return result;
	}
	
	public static void main(String[] args) {
		FourSum s = new FourSum();
		
		int[] nums = new int[] {1, 0, -1, 0, -2, 2};
		System.out.println(s.fourSum(nums, 0));
	}
}

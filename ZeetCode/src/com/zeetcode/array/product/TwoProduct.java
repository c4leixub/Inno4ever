package com.zeetcode.array.product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TwoProduct {
	public List<List<Integer>> getAllProductPairs(int[] nums, int target) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (target == 0) {
				if (nums[i] != 0) {
					ret.add(Arrays.asList(new Integer[] {nums[i], 0}));
				}
			} else {
				if (nums[i] != 0 && target % nums[i] == 0) {
					int d = target / nums[i];
					if (set.contains(d)) {
						ret.add(Arrays.asList(new Integer[] {nums[i], d}));
					} else {
						set.add(nums[i]);
					}
				}
			}
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		TwoProduct p = new TwoProduct();
		int nums[] = new int[] {2, 6, 3, 1, 0, 4, 5};
		System.out.println(p.getAllProductPairs(nums, 6));
		System.out.println(p.getAllProductPairs(nums, 0));
	}
}

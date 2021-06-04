package com.twt.zoa.array;

import java.util.*;

public class PartitionArray {
	
	public String solve(int k, int[] nums) {
		if (nums.length % k != 0) {
			return "No";
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		
		int num, count;
		for (int i = 0; i < nums.length; i++) {
			num = nums[i];
			count = map.getOrDefault(num, 0) + 1;
			map.put(num, count);
			
			if (count > (nums.length / k)) {
				return "No";
			}
		}
		
		return "Yes" ;
	}
}

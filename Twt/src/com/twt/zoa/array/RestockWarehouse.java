package com.twt.zoa.array;

public class RestockWarehouse {
	
	public int restock(int[] itemCount, int target) {
		int sum = 0;
		for (int i = 0; i < itemCount.length; i++) {
			sum += itemCount[i];
			if (sum >= target) {
				return sum - target;
			}
		}
		
		return target - sum;
	}
}

package com.twt.zoa.array;

import java.util.*;

public class BalancedArray {
	public int balancedSum(List<Integer> sales) {
		
		int sum = 0;
		for (Integer e : sales) {
			sum += e.intValue();
		}
		
		int curSum = sales.get(0);
		for (int i = 1; i < sales.size(); i++) {
			if (curSum == sum - curSum - sales.get(i)) {
				return i;
			}
			curSum += sales.get(i);
		}
		
		return -1;
	}
}

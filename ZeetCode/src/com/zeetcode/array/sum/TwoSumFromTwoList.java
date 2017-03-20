package com.zeetcode.array.sum;

import java.util.Arrays;

public class TwoSumFromTwoList {
	
	public boolean hasSum(int[] array1, int[] array2, int target) {
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		int s1 = 0, e1 = array1.length, s2 = 0, e2 = array2.length;
		while (s1 <= e1 && s2 <= e2) {
			int sum = Math.min(array1[s1], array1[s2]) + Math.max(array1[e1], array1[e2]);
			if (sum == target) return true;
			
			if (sum < target) {
				if(array1[s1] < array1[s2]) {
					s1++;
				} else {
					s2++;
				}
			} else {
				if (array1[e1] < array1[e2]) {
					e2--;
				} else {
					e1--;
				}
			}
			
		}
		
		return false;
	}
}

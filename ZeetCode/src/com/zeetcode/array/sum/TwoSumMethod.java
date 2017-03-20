package com.zeetcode.array.sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TwoSumMethod {
	
	public static boolean hasSum(int[] A, int target) {
		boolean result = false;
		if (A == null || A.length < 2) return result;
		
		Arrays.sort(A); // ascending order, O(nlogn)
		int i = 0, j = A.length - 1;
		while (i < j) {					// O(n)
			if (A[i] + A[j] == target) {
				return true;
			} else if (A[i] + A[j] > target) {
				j--;
			} else {
				i++;
			}
		}
		return result;		// O(n+nlogn)=O(nlogn)
	}
	
	public static boolean hasSumHash(int[] A, int target) {
		if (A == null || A.length < 2) return false;
		
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i : A) {
			if (hs.contains(target-i)) {
				return true;
			} else {
				hs.add(i);
			}
		}
		return false;
	}
}

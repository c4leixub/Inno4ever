package com.zeetcode.array.finding;

public class MinimiumAbsoluteDifference {
	
	public int minimiumAbsoluteDifference(int[] A, int[] B) {
		
		int min = Integer.MAX_VALUE;
		
		int i = 0, j = 0;
		while (i < A.length && j < B.length) {
			min = Math.min(Math.abs(A[i]-B[i]), min);
			if (A[i] <= B[j]) {
				i++;
			} else {
				j++;
			}
		}
		
		return min;
	}
}

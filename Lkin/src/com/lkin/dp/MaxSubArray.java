package com.lkin.dp;

public class MaxSubArray {
	public int maxSubArray(int[] A) {
		int max = A[0];
		int[] sum = new int[A.length];
		sum[0] = A[0];

		for (int i = 1; i < A.length; i++) {
			sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
			max = Math.max(max, sum[i]);
		}

		return max;
	}

	public int maxSubArray2(int[] A) {
		int newsum = A[0];
		int max = A[0];
		for (int i = 1; i < A.length; i++) {
			newsum = Math.max(newsum + A[i], A[i]);
			max = Math.max(max, newsum);
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		MaxSubArray m = new MaxSubArray();
		m.maxSubArray(A);
	}
}

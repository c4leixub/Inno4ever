package com.zeetcode.array.finding;

public class FirstMissingPositive {

	/**
	 * Given an unsorted integer array, find the first missing positive integer.
	 * 
	 * O(n) time and uses constant space.
	 */
	public int firstMissingPositive(int[] A) {
		int n = A.length;

		for (int i = 0; i < n; i++) {
			while (A[i] != i + 1) {
				if (A[i] <= 0 || A[i] >= n)
					break;

				if (A[i] == A[A[i] - 1])
					break;

				int temp = A[i];
				A[i] = A[temp - 1];
				A[temp - 1] = temp;
			}
		}

		for (int i = 0; i < n; i++) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}

		return n + 1;

	}
}

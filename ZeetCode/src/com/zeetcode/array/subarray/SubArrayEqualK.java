package com.zeetcode.array.subarray;

public class SubArrayEqualK {

	public boolean sumsToX(int[] arr, int target) {
		int start = 0, end = 0, sum = 0;
		while (end < arr.length) {
			if (sum + arr[end] <= target) {
				sum += arr[end++];
			} else {
				sum -= arr[start++];
			}
			if (sum == target) {
				return true;
			}
			if (end < start) {
				end = start;
				sum = 0;
			}
		}
		return false;
	}
}

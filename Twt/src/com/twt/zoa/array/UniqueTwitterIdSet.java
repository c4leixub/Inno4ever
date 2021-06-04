package com.twt.zoa.array;

import java.util.Arrays;

/**
 * Twitter needs user ids to be unique and while assigning the user ids to its
 * customers, Twitter wants to have the sum of the user ids to be minimum. Given
 * an array of random user ids for n users, increment any duplicate elements
 * untils all the user ids are unique and ensure that their sum is minimum.
 * 
 * Example: Input: arr = [3, 2, 1, 2, 7] output: 17
 * 
 * Explanation：if arr = [3, 2, 1, 2, 7],
 * 
 * then arr(unique) = [3, 2, 1, 4, 7] and its user ids sum to a minimal value of
 * 3 + 2 + 1 + 4 + 7 = 17
 *
 */
public class UniqueTwitterIdSet {
	public int UniqueIDSum(int[] arr) {
		Arrays.sort(arr);

		for (int i = 0; i + 1 < arr.length; i++) {
			if (arr[i] >= arr[i + 1]) {
				arr[i + 1] = arr[i] + 1;
			}
		}

		int res = 0;
		for (int a : arr) {
			res += a;
		}

		return res;
	}

	public static void main(String[] args) {
		UniqueTwitterIdSet u = new UniqueTwitterIdSet();

		int[] arr = new int[] { 1, 2, 2, 2, 3 };
		System.out.println(u.UniqueIDSum(arr));
	}
}

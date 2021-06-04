package com.twt.zoa.array;

import java.util.*;

public class BuyPasses {

	/**
	 * @param arr: the line
	 * @param k:   Alex place
	 * @return: the time when Alex requires to buy all passes
	 */
	public int buyPasses(int[] arr, int k) {
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i <= k) {
				ans += Math.min(arr[i], arr[k]);
			} else {
				ans += Math.min(arr[i], arr[k] - 1);
			}
		}
		return ans;
	}

	public int buyPassesTimeLimitExceed(int[] arr, int k) {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			q.add(i);
		}

		Integer e;
		int result = 0;
		while (!q.isEmpty()) {
			e = q.poll();
			arr[e]--;
			result++;
			if (arr[e] != 0) {
				q.add(e);
			} else {
				if (e == k) {
					break;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		BuyPasses b = new BuyPasses();
		int[] arr;
		int k;

		arr = new int[] { 1, 2, 5 };
		k = 1;
		System.out.println(b.buyPasses(arr, k));

		arr = new int[] { 3, 2, 1 };
		k = 0;
		System.out.println(b.buyPasses(arr, k));

		arr = new int[] { 3, 2, 3 };
		k = 1;
		System.out.println(b.buyPasses(arr, k));

		arr = new int[] { 1, 2, 5 };
		k = 1;
		System.out.println(b.buyPassesTimeLimitExceed(arr, k));

		arr = new int[] { 3, 2, 1 };
		k = 0;
		System.out.println(b.buyPassesTimeLimitExceed(arr, k));

		arr = new int[] { 3, 2, 3 };
		k = 1;
		System.out.println(b.buyPassesTimeLimitExceed(arr, k));

	}
}

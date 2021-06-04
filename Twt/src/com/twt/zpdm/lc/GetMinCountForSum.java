package com.twt.zpdm.lc;

public class GetMinCountForSum {

	/*
	 * each e in arr, abs(e) <= k.
	 * find min elements include in arr <= k + sum(arr) = S
	 */
	public int min(int S, int k, int[] arr) {
		
		int sum = 0;
		for (int e : arr) sum += e;
		
		int a = S - sum;
		if (a % k == 0) {
			return Math.abs(a) / k;
		}
		
		return Math.abs(a) / k + 1;
	}
	
	public static void main(String[] args) {
		
		GetMinCountForSum g = new GetMinCountForSum();
		
		int S = 10;
		int k = 3;
		int[] arr = new int[] {3,3,-1};
		System.out.println(g.min(S, k, arr));
		
		S = 7;
		k = 4;
		arr = new int[] {3,3,-1};
		System.out.println(g.min(S, k, arr));
	}
}

package com.twt.zoa.greedy;

import java.util.*;

public class ActiveFountain {

	public int minTaps(int n, int[] ranges) {

		List<int[]> intervals = new ArrayList<>();
		for (int i = 0; i < ranges.length; i++) {
			intervals.add(new int[] { Math.max(0, i - ranges[i]), Math.min(n, i + ranges[i]) });
		}

		Collections.sort(intervals, (a, b) -> {
			if (a[0] == b[0]) {
				return Integer.compare(a[1], b[1]);
			}
			return Integer.compare(a[0], b[0]);
		});

		int ans = 0;
		int i = 0, l = 0, e = 0;
		while (e < n) {
			while (i <= n && intervals.get(i)[0] <= l) {
				e = Math.max(e, intervals.get(i)[1]);
				i++;
			}
			
			if (l == e) return -1;
			
			l = e;
			ans++;
		}

		return ans;
	}

	public int minTapBetter(int n, int[] ranges) {
		int[] nums = new int[ranges.length];
		for (int i = 0; i < ranges.length; i++) {
			int s = Math.max(0, i - ranges[i]);
			nums[s] = Math.max(nums[s], i + ranges[i]);
		}

		int steps = 0;
		int l = 0;
		int e = 0;
		for (int i = 0; i <= n; ++i) {
			if (i > e)
				return -1;
			if (i > l) {
				steps++;
				l = e;
			}
			e = Math.max(e, nums[i]);
		}
		return steps;
	}

	public static void main(String[] args) {
		ActiveFountain a = new ActiveFountain();

		int n = 5;
		int[] ranges = new int[] { 3, 4, 1, 1, 0, 0 };
		System.out.println(a.minTaps(n, ranges));

		n = 3;
		ranges = new int[] { 0, 0, 0, 0 };
		System.out.println(a.minTaps(n, ranges));

		n = 7;
		ranges = new int[] { 1, 2, 1, 0, 2, 1, 0, 1 };
		System.out.println(a.minTaps(n, ranges));

		n = 8;
		ranges = new int[] { 4, 0, 0, 0, 0, 0, 0, 0, 4 };
		System.out.println(a.minTaps(n, ranges));

		n = 8;
		ranges = new int[] { 4, 0, 0, 0, 4, 0, 0, 0, 4 };
		System.out.println(a.minTaps(n, ranges));

		n = 9;
		ranges = new int[] { 0, 5, 0, 3, 3, 3, 1, 4, 0, 4 };
		System.out.println(a.minTaps(n, ranges));
	}
}

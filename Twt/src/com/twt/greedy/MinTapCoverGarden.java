package com.twt.greedy;

import java.util.*;

/**
 * There is a one-dimensional garden on the x-axis. The garden starts at the
 * point 0 and ends at the point n. (i.e The length of the garden is n).
 * 
 * There are n + 1 taps located at points [0, 1, ..., n] in the garden.
 * 
 * Given an integer n and an integer array ranges of length n + 1 where
 * ranges[i] (0-indexed) means the i-th tap can water the area [i - ranges[i], i
 * + ranges[i]] if it was open.
 * 
 * Return the minimum number of taps that should be open to water the whole
 * garden, If the garden cannot be watered return -1. 
 */
public class MinTapCoverGarden {

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

			if (l == e)
				return -1;

			l = e;
			ans++;
		}

		return ans;
	}

	public int minTapsFaster(int n, int[] ranges) {
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
}

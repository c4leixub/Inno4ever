package com.twt.ltc.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interval {

	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> res = new ArrayList<>();
		for (int[] interval : intervals) {
			if (interval[1] < newInterval[0]) {
				res.add(interval);
			} else if (newInterval[1] < interval[0]) {
				res.add(newInterval);
				newInterval = interval;
			} else {
				newInterval[0] = Math.min(interval[0], newInterval[0]);
				newInterval[1] = Math.max(interval[1], newInterval[1]);
			}
		}
		res.add(newInterval);

		return res.toArray(new int[0][0]);
	}

	public int[][] merge(int[][] intervals) {
		
		if (intervals.length == 0) {
			return intervals;
		}
		
		// intervals needs to be sorted in order for the loop to work
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		
		List<int[]> res = new ArrayList<>();
		int[] pre = intervals[0], cur;
		for (int i = 1; i < intervals.length; i++) {
			cur = intervals[i];
			if (pre[1] < cur[0]) {
				res.add(pre);
				pre = cur;
			} else {
				pre[1] = Math.max(pre[1], cur[1]);
			}
		}
		res.add(pre);

		return res.toArray(new int[0][0]);
	}
}

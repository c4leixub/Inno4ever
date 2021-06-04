package com.fcb.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

	public int[][] merge(int[][] intervals) {
		
		if (intervals == null || intervals.length <= 1) {
			return intervals;
		}
		
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		
		List<int[]> res = new ArrayList<>();
		int[] merged = new int[] {intervals[0][0], intervals[0][1]};
		for (int[] interval : intervals) {
			if (merged[1] < interval[0]) {
				res.add(merged);
				merged = new int[] {interval[0], interval[1]};;
			} else {
				merged[0] = Math.min(merged[0], interval[0]);
				merged[1] = Math.max(merged[1], interval[1]);
			}
		}
		res.add(merged);
		
		int[][] result = new int[res.size()][2];
		for (int i = 0; i < res.size(); i++) {
			result[i] = res.get(i);
		}
		return result;

	} 
	
	public static void main(String[] args) {
		int[][] intervals = new int[][] {{1,3},{2,6},{8,10},{15,18}};
		MergeInterval m = new MergeInterval();
		m.merge(intervals);
	}
}

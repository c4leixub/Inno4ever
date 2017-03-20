package com.zeetcode.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IntervalsImpl implements Intervals {
	
	List<Interval> intervals = new ArrayList<Interval>();
	
	@Override
	public void addInterval(int from, int to) {
		intervals.add(new Interval(from, to));
	}

	@Override
	public int getTotalCoveredLength() {
		if (intervals.size() == 0) return 0;
		
		List<Interval> result = new ArrayList<Interval>();
		
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
		
		Interval pre = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (pre.end >= cur.start) {
				Interval merged = new Interval(pre.start, Math.max(pre.end, cur.end));
				pre = merged;
			} else {
				result.add(pre);
				pre = cur;
			}
		}
		result.add(pre);
		
		intervals.clear();
		intervals.addAll(result);
		int count = 0;
		for (Interval e : intervals) {
			count += e.end-e.start;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Intervals a = new IntervalsImpl();
		a.addInterval(3, 6);
		a.addInterval(8, 9);
		a.addInterval(1, 5);
		
		System.out.println(a.getTotalCoveredLength());
		
	}

}

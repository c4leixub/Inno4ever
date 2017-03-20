package com.zeetcode.interval;

import java.util.ArrayList;
import java.util.List;

public class IntervalsSortInsertImpl implements Intervals {

	List<Interval> intervals = new ArrayList<Interval>();
	
	@Override
	public void addInterval(int from, int to) {
		int i = 0;
		Interval e;
		while (i < intervals.size()) {
			e = intervals.get(i);
			if (e.start > from) {
				break;
			}
			i++;
		}
		intervals.add(i, new Interval(from, to));
	}

	@Override
	public int getTotalCoveredLength() {
		if (intervals.size() == 0) return 0;
		
		List<Interval> result = new ArrayList<Interval>();
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
		
		int count = 0;
		for (Interval e : result) {
			count += e.end-e.start;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Intervals a = new IntervalsSortInsertImpl();
		a.addInterval(3, 6);
		a.addInterval(8, 9);
		a.addInterval(1, 5);
		
		System.out.println(a.getTotalCoveredLength());
		
	}
	
}

package com.zeetcode.interval;

import java.util.ArrayList;
import java.util.List;

public class IntervalsInsertMergeImpl implements Intervals {

	public List<Interval> intervals = new ArrayList<Interval>();
	public int cover;
	
	@Override
	public void addInterval(int from, int to) {
		List<Interval> result = new ArrayList<Interval>();
		cover = 0;
		
		int i = 0;
		Interval e;
		while (i < intervals.size()) {
			e = intervals.get(i);
			if (e.end < from) {
				result.add(e);
				cover += (e.end - e.start);
			} else if (to < e.start) {
				result.add(new Interval(from, to));
				cover += (to-from);
				
				from = e.start;
				to = e.end;
			} else if (e.end >= from || e.start <= to) {
				from = Math.min(from, e.start);
				to = Math.max(to, e.end);
			}
			i++;
		}
		
		result.add(new Interval(from, to));
		cover += (to-from);
		
		intervals.clear();
		intervals.addAll(result);
	}

	@Override
	public int getTotalCoveredLength() {
		int count = 0;
		for (Interval e : intervals) {
			count += e.end-e.start;
		}
		
		return count;
	}
	
	public List<Interval> removeInterval(int from, int to) {
		List<Interval> result = new ArrayList<Interval>();
		
		int i = 0;
		Interval e;
		while (i < intervals.size()) {
			e = intervals.get(i);
			if (e.end < from || e.start > to) {	// outside of (from, to)
				result.add(e);
			} else {
				if (e.start < from && to < e.end) {
					// split the interval
					result.add(new Interval(e.start, from));
					result.add(new Interval(to, e.end));
				} else if (from <= e.start && e.end <= to) {
					// skip the interval (delete it)
				} else if (from < e.start) {
					result.add(new Interval(to, e.end));
				} else if (e.end < to) {	
					result.add(new Interval(e.start, from));
				}
			}
			i++;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		IntervalsInsertMergeImpl a = new IntervalsInsertMergeImpl();
		a.addInterval(1, 5);
		a.addInterval(2, 7);
		a.addInterval(6, 9);
		
		System.out.println(a.intervals);
		System.out.println(a.getTotalCoveredLength());
		System.out.println(a.cover);
		System.out.println();
		
		IntervalsInsertMergeImpl b = new IntervalsInsertMergeImpl();
		b.addInterval(1, 5);
		b.addInterval(7, 9);
		System.out.println(b.intervals);
		System.out.println(b.removeInterval(1, 9));
		System.out.println();
		
		IntervalsInsertMergeImpl c = new IntervalsInsertMergeImpl();
		b.addInterval(1, 5);
		b.addInterval(7, 9);
		b.addInterval(4, 8);
		System.out.println(b.intervals);
		System.out.println();
	}

}

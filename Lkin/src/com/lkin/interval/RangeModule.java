package com.lkin.interval;

import java.util.ArrayList;
import java.util.List;

import com.common.structs.Interval;

public class RangeModule {

	private List<Interval> intervals;

	public RangeModule() {
		intervals = new ArrayList<Interval>();
	}

	public void addRange(int left, int right) {
		if (intervals.isEmpty()) {
			intervals.add(new Interval(left, right));
			return;
		}
		
		intervals = insert(intervals, new Interval(left, right));
	}
	
	private List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
		for (Interval interval : intervals) {
			if (interval.end < newInterval.start) {
				result.add(interval);
			} else if (newInterval.end < interval.start) {
				result.add(newInterval);
				newInterval = interval;
			} else {
				int start = Math.min(interval.start, newInterval.start);
				int end = Math.max(interval.end, newInterval.end);
				newInterval = new Interval(start, end);
			}
		}
		result.add(newInterval);
		
		return result;
	}

	public boolean queryRange(int left, int right) {
		for (Interval interval : intervals) {
			if (interval.start <= left && right <= interval.end) {
				return true;
			}
		}
		
		return false;
	}

	public void removeRange(int left, int right) {
		if (intervals.isEmpty()) return;
		
		List<Interval> result = new ArrayList<Interval>();
		int i = 0;
		while (i < intervals.size()) {
			Interval interval = intervals.get(i);
			if (interval.end < left) {
				result.add(interval);
			} else if (right < interval.start) {
				result.add(interval);
			} else {
				if (left > interval.start) {
					result.add(new Interval(interval.start, left));
				}
	
				if (right < interval.end) {
					result.add(new Interval(right, interval.end));
				}				
			}
			i++;
		}
		
		intervals = result;
	}
	
	public static void main(String[] args) {
		RangeModule r = new RangeModule();
		
		r.addRange(10, 180);
		r.addRange(150, 200);
		r.addRange(250, 500);
		
		System.out.println(r.intervals);
		
		r.removeRange(50, 150);
		
		System.out.println(r.intervals);
		
		System.out.println(r.queryRange(50, 100));
		
	}
}

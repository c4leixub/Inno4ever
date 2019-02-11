package com.lkin.interval;

import java.util.ArrayList;
import java.util.List;

import com.common.structs.Interval;

public class InsertInerval57 {
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
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
}

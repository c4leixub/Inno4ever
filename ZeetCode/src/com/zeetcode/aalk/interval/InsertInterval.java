package com.zeetcode.aalk.interval;

import java.util.ArrayList;
import java.util.List;

import com.zeetcode.interval.Interval;

/**
 * Given a set of non-overlapping & sorted intervals, insert a new interval into
 * the intervals (merge if necessary).
 */
public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();

		for (Interval interval : intervals) {
			if (interval.end < newInterval.start) { 
				result.add(interval);	// newInterval isn't overlap to any
			} else if (interval.start > newInterval.end) {	
				// newInterval is biggest so far, change the newInterval to 
				// make merge possible later
				result.add(newInterval);		
				newInterval = interval;
			} else if (interval.end >= newInterval.start
					|| interval.start <= newInterval.end) {
				newInterval = new Interval(Math.min(interval.start,
						newInterval.start), Math.max(newInterval.end,
						interval.end));
			}
		}

		result.add(newInterval); // newInterval bigger than all intervals

		return result;
	}
}

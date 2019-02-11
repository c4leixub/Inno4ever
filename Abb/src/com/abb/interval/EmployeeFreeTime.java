package com.abb.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.common.structs.Interval;

public class EmployeeFreeTime {
	
	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		
		List<Interval> intervals = new ArrayList<Interval>();
		for (List<Interval> list : schedule) {
			intervals.addAll(list);
		}
		
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		
		List<Interval> result = new ArrayList<Interval>();
		Interval merge = intervals.get(0), interval;
		for (int i = 1; i < intervals.size(); i++) {
			interval = intervals.get(i);
			if (interval.start <= merge.end) {
				merge.end = Math.max(merge.end, interval.end);
			} else {
				// instead of add merge interval we add gap
				result.add(new Interval(merge.end, interval.start));
				merge = interval;
			}
		}
		
		return result;
	}
}

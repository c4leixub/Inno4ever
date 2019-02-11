package com.lkin.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.common.structs.Interval;

public class MergeInterval56 {
	public List<Interval> merge(List<Interval> intervals) {
        
		List<Interval> result = new ArrayList<Interval>();
		if (intervals.isEmpty()) {
			return result;
		}
		
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		
		Interval merge = intervals.get(0), interval;
		for (int i = 1; i < intervals.size(); i++) {
			interval = intervals.get(i);
			if (interval.start <= merge.end) {
				merge.end = Math.max(merge.end, interval.end);
			} else {
				result.add(merge);
				merge = interval;
			}
		}
		
		result.add(merge);
		return result;
    }
}

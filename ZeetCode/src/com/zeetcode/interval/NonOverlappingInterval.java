package com.zeetcode.interval;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingInterval {
	public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
			return 0;
        
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                }
                
                return o1.end - o2.end;
            }
        });
        
        int count = 0;
        Interval pre = intervals[0];
        int i = 1;
        while (i < intervals.length) {
            if (pre.end <= intervals[i].start) {
                pre = intervals[i]; 
            } else {    
                count++;
                
                // merge only when whole intervals[i] inside pre 
                if (intervals[i].end < pre.end) {
                    pre = intervals[i]; 
                }
            }
            i++;
        }
        
        return count;
    }
}

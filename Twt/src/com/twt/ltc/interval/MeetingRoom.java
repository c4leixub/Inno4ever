package com.twt.ltc.interval;

import java.util.*;

public class MeetingRoom {
	
	public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return true;
        
        Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] i1, int[] i2) {
				return i1[0] - i2[0];
			}
		});
        
        int[] interval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (interval[1] <= intervals[i][0]) {
                interval = intervals[i];
            } else {
                return false;
            }
        }
        
        return true;
    }
	
	public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
			return 0;
        
        Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] i1, int[] i2) {
				return i1[0] - i2[0];
			}
		});
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		int count = 1;
		queue.offer(intervals[0][1]);

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < queue.peek()) {
				count++;

			} else {
				queue.poll();
			}

			queue.offer(intervals[i][1]);
		}

		return count;
    }
}

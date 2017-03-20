package com.zeetcode.interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] si < ei
 */
public class MeetingRoom {

	/** Determine if a person could attend all meetings. */
	public boolean canAttendMeetings(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return true;

		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});

		Interval pre = intervals[0];
		Interval cur;
		for (int i = 1; i < intervals.length; i++) {
			cur = intervals[i];
			if (pre.end > cur.start)
				return false;
			pre = cur;
		}

		return true;
	}

	/** find the minimum number of conference rooms required. */
	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;

		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		int count = 1;
		queue.offer(intervals[0].end);

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < queue.peek()) {
				count++;

			} else {
				queue.poll();
			}

			queue.offer(intervals[i].end);
		}

		return count;
	}
}

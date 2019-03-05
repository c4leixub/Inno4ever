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

	class Point implements Comparable<Point> {
		int time;
		boolean isStart;

		Point(int time, boolean isStart) {
			this.time = time;
			this.isStart = isStart;
		}

		@Override
		public int compareTo(Point that) {
			if (this.time != that.time || this.isStart == that.isStart) {
				return this.time - that.time;
			} else {
				return this.isStart ? -1 : 1;
			}
		}
	}

	// follow up, find free time with at least K employee
	public List<Interval> employeeFreeTime(List<List<Interval>> schedule, int k) {
		List<Interval> res = new ArrayList<>();

		List<Point> points = new ArrayList<>();
		for (List<Interval> intervalList : schedule) {
			for (Interval interval : intervalList) {
				points.add(new Point(interval.start, true));
				points.add(new Point(interval.end, false));
			}
		}
		Collections.sort(points);
		
		int count = 0;
		Integer availableStart = null;
		for (int i = 0; i < points.size(); i++) {
			Point point = points.get(i); 
			if (point.isStart) {
				count++;
				if (availableStart == null && i == 0 && count <= schedule.size() - k) {
					availableStart = point.time;
				} else if (availableStart != null && count == schedule.size() - k + 1) {
					res.add(new Interval(availableStart, point.time));
					availableStart = null; 
				}
			} else { 
				count--;
				if (count == schedule.size() - k && i < points.size() - 1) {
					availableStart = point.time;
				} else if (availableStart != null && i == points.size() - 1
								&& count <= schedule.size() - k) {
					res.add(new Interval(availableStart, point.time));
					availableStart = null; 
				}
			}
		} 
		
		return res;
	}
}

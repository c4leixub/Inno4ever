package com.zeetcode.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountAirPlaneInSky {
	class Point implements Comparable<Point> {
		int time;
		int flag;

		Point(int t, int s) {
			this.time = t;
			this.flag = s;
		}

		@Override
		public int compareTo(Point p) {
			if (this.time == p.time) {
				return this.flag - p.flag;
			}
			return this.time - p.time;
		}
	}

	/**
	 * @param intervals
	 *            : An interval array
	 * @return: Count of airplanes are in the sky.
	 */
	public int countOfAirplanes(List<Interval> airplanes) {
		List<Point> list = new ArrayList<Point>(airplanes.size() * 2);
		for (Interval i : airplanes) {
			list.add(new Point(i.start, 1));
			list.add(new Point(i.end, 0));
		}

		Collections.sort(list);
		int count = 0, ans = 0;
		for (Point p : list) {
			if (p.flag == 1)
				count++;
			else
				count--;
			ans = Math.max(ans, count);
		}

		return ans;
	}

}

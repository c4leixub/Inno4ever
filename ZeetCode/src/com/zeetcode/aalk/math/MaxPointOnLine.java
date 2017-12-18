package com.zeetcode.aalk.math;

import java.util.HashMap;
import java.util.Map;

public class MaxPointOnLine {

	public class Point {
		public int x;
		public int y;
	}

	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0)
			return 0;
		if (points.length == 1)
			return 1;

		int max = 1;

		for (int i = 0; i < points.length; ++i) {
			Map<Map<Integer, Integer>, Integer> result = new HashMap<Map<Integer, Integer>, Integer>();
			
			// duplicate="how many point is same as point[i]
			// vertical line start with point count=1
			int duplicate = 0, vertical = 1;

			for (int j = i + 1; j < points.length; ++j) {

				// handle duplicate and vertical slope
				if (points[i].x == points[j].x) {
					if (points[i].y == points[j].y) {
						duplicate++;
					} else {
						vertical++;
					}
				} else {
					Map<Integer, Integer> slope = slope(points[i], points[j]);
					if (result.containsKey(slope)) {
						result.put(slope, result.get(slope) + 1);
					} else {
						result.put(slope, 2);
					}
				}
			}

			for (Integer count : result.values()) {
				max = Math.max(max, count + duplicate);
			}
			max = Math.max(vertical + duplicate, max);
		}
		
		return max;
	}

	// using fraction to solve precise value problem in division
	private Map<Integer, Integer> slope(Point p1, Point p2) {
		int dx = p2.x - p1.x;
		int dy = p2.y - p1.y;
		int d = gcd(dx, dy);

		// the slope in fraction form
		Map<Integer, Integer> fraction = new HashMap<Integer, Integer>();
		fraction.put(dx / d, dy / d);

		return fraction;
	}

	private int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, a % b);
	}
}

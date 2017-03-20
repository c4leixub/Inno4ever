package com.zeetcode.math.points;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LineReflection {
	public boolean isReflected(int[][] points) {
		if (points == null || points.length < 2)
			return true;

		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;

		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		
		for (int[] point : points) {
			minX = Math.min(minX, point[0]);
			maxX = Math.max(maxX, point[0]);
			
			if (!map.containsKey(point[0])) {
				map.put(point[0], new HashSet<Integer>());
			}
			map.get(point[0]).add(point[1]);
		}
		
		int t = minX + maxX;
		for (int[] point : points) {
			int left = point[0];
			int right = t - left;
			
			// if (x, y) can reflected, then (t-x, y) exists
			if (map.get(right) == null
					|| !map.get(right).contains(point[1])) {
				return false;
			}
		}

		return true;
	}
}

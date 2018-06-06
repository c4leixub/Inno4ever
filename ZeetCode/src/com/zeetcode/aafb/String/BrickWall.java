package com.zeetcode.aafb.String;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
	public int leastBricks(List<List<Integer>> wall) {

		// The value is number of rows with subsequence bricks sum equals Key
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (List<Integer> rowBricks : wall) {
			int sum = 0;
			for (int i = 0; i < rowBricks.size() - 1; i++) {
				sum += rowBricks.get(i);
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}

		// loop all the sub-sums, find the max number of rows
		int max = 0;
		for (Integer sum : map.keySet()) {
			max = Math.max(max, map.get(sum));
		}

		return wall.size() - max;
	}
}

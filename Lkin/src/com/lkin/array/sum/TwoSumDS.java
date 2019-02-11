package com.lkin.array.sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSumDS {
	Map<Integer, Integer> map;

	/** Initialize your data structure here. */
    public TwoSumDS() {
        map = new HashMap<Integer, Integer>();
    }

	/** Add the number to an internal data structure.. */
	public void add(int number) {
		map.put(number, map.getOrDefault(number, 0) + 1);
	}

	/** Find if there exists any pair of numbers which sum is equal to the value. */
	public boolean find(int value) {
		for (Integer num : map.keySet()) {
			if (map.containsKey(value - num) && (value != 2 * num || map.get(value - num) >= 2)) {
				return true;
			}
		}
		return false;
	}
}

package com.twt.zpdm.randomweight;

import java.util.*;

public class RadomPickByWeight {

	Map<String, Integer> map;
	int totalSum;

	public RadomPickByWeight() {
		map = new HashMap<>();
		totalSum = 0;
	}

	public void add(String item) {
		totalSum += 1;
		map.put(item, map.getOrDefault(item, 0) + 1);
	}

	public String recommend() {
		double target = this.totalSum * Math.random();

		List<Map.Entry<String, Integer>> items = new ArrayList<>(map.entrySet());

		int i = 0, sum = 0;
		while (i < items.size()) {
			sum += items.get(i).getValue();
			if (target < sum) {
				return items.get(i).getKey();
			}
			i++;
		}

		return items.get(i - 1).getKey();
	}

}

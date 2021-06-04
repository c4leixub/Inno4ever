package com.twt.ltc.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;

public interface TimeMap {

	Map<String, List<Pair<Integer, String>>> map = new HashMap<>();

	default void set(String key, String value, int timestamp) {
		List<Pair<Integer, String>> timesAndVals = map.get(key);
		if (timesAndVals == null) {
			timesAndVals = new ArrayList<>();
			map.put(key, timesAndVals);
		}

		timesAndVals.add(new Pair<>(timestamp, value));
	}

	default String get(String key, int timestamp) {
		List<Pair<Integer, String>> timesAndVals = map.get(key);
		if (timesAndVals == null) {
			return "";
		}

		// if timestamp not found, then return (-(insertion point)-1)
		int i = Collections.binarySearch(timesAndVals, new Pair<Integer, String>(timestamp, ""),
				(a, b) -> Integer.compare(a.getKey(), b.getKey()));

		if (i >= 0) {
			return timesAndVals.get(i).getValue();
		} else if (i == -1) {
			return "";
		} else {
			// i = -ip-1, -i = ip+1, -i-1 = ip => -i-2 = ip-1 is the index we need
			return timesAndVals.get(-i - 2).getValue();
		}
	}
}

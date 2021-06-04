package com.twt.ltc.binarysearch;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMapImpl implements TimeMap {

	Map<String, TreeMap<Integer, String>> map;

	/** Initialize your data structure here. */
	public TimeMapImpl() {
		map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		TreeMap<Integer, String> timeToVal = map.get(key);
		if (timeToVal == null) {
			timeToVal = new TreeMap<>();
			map.put(key, timeToVal);
		}

		timeToVal.put(timestamp, value);
	}

	public String get(String key, int timestamp) {
		TreeMap<Integer, String> timeToVal = map.get(key);
		if (timeToVal == null) {
			return "";
		}

		Integer t = timeToVal.floorKey(timestamp);
		return t != null ? timeToVal.get(t) : "";
	}
}

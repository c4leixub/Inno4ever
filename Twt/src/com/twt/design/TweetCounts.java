package com.twt.design;

import java.util.*;

public class TweetCounts {

	Map<String, TreeMap<Integer, Integer>> map;

	public TweetCounts() {
		map = new HashMap<>();
	}

	public void recordTweet(String tweetName, int time) {
		TreeMap<Integer, Integer> timeAndCounts = map.get(tweetName);
		if (timeAndCounts == null) {
			timeAndCounts = new TreeMap<>();
			map.put(tweetName, timeAndCounts);
		}
		timeAndCounts.put(time, timeAndCounts.getOrDefault(time, 0) + 1);
	}

	public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
		TreeMap<Integer, Integer> timeAndCounts = map.get(tweetName);
		if (timeAndCounts == null || timeAndCounts.isEmpty()) {
			return new ArrayList<>();
		}

		int delta = 1;
		if ("minute".equals(freq)) {
			delta = 60;
		} else if ("hour".equals(freq)) {
			delta = 60 * 60;
		} else if ("day".equals(freq)) {
			delta = 24 * 60 * 60;
		}

		int size = (endTime - startTime) / delta + 1;
		Integer[] res = new Integer[size];
		for (int i = 0; i < size; i++) {
			res[i] = new Integer(0);
		}

		int index;
		Map<Integer, Integer> sub = timeAndCounts.subMap(startTime, endTime + 1);
		for (Map.Entry<Integer, Integer> entry : sub.entrySet()) {
			index = (entry.getKey() - startTime) / delta;
			res[index] += entry.getValue();
		}

		return Arrays.asList(res);
	}
}

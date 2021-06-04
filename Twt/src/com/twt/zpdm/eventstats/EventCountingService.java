package com.twt.zpdm.eventstats;

import java.util.*;

public class EventCountingService {

	enum Granularity {
		MINUTE, HOUR, DAY
	}

	private Map<String, TreeMap<Long, Long>> map; // event to time and count;

	public EventCountingService() {
		map = new HashMap<>();
	}

	public void recordEvent(String eventType, long timeInMillis) {
		TreeMap<Long, Long> timeAndCounts = map.get(eventType);
		if (timeAndCounts == null) {
			timeAndCounts = new TreeMap<>();
			map.put(eventType, timeAndCounts);
		}
		timeAndCounts.put(timeInMillis, timeAndCounts.getOrDefault(timeInMillis, 0L) + 1);
	}

	public long[] getEventCounts(Granularity granularity, String eventType, long startTime, long endTime) {
		TreeMap<Long, Long> timeAndCounts = map.get(eventType);
		if (timeAndCounts == null || timeAndCounts.isEmpty()) {
			return new long[0];
		}

		int delta = 1;
		if (Granularity.MINUTE.equals(granularity)) {
			delta = 60;
		} else if (Granularity.HOUR.equals(granularity)) {
			delta = 60 * 60;
		} else if (Granularity.DAY.equals(granularity)) {
			delta = 24 * 60 * 60;
		}

		int size = ((int) (endTime - startTime)) / delta + 1;
		long[] res = new long[size];

		int index;
		NavigableMap<Long, Long> sub = timeAndCounts.subMap(startTime, true, endTime, true);
		for (Map.Entry<Long, Long> entry : sub.entrySet()) {
			index = ((int) (entry.getKey().longValue() - startTime)) / delta;
			res[index] += entry.getValue();
		}

		return res;
	}
	
	public static void main(String[] args) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(1, 2);
		map.put(5, 6);
		map.put(3, 4);
		
		NavigableMap<Integer, Integer> sub = map.subMap(3, true, 6, true);
		System.out.println(sub.entrySet());
	}

}

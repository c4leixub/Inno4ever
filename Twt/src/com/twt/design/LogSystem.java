package com.twt.design;

import java.util.*;

public class LogSystem {

	// constants
	String minTimeStamp;
	String maxTimeStamp;
	Map<String, Integer> graMap;

	TreeMap<String, List<Integer>> timeToIdMap;

	public LogSystem() {

		minTimeStamp = "2000:01:01:00:00:00";
		maxTimeStamp = "2017:12:31:23:59:59";

		graMap = new HashMap<>(); // granularity to ":" index where granularity end
		graMap.put("Year", 4);
		graMap.put("Month", 7);
		graMap.put("Day", 10);
		graMap.put("Hour", 13);
		graMap.put("Minute", 16);
		graMap.put("Second", 19);

		timeToIdMap = new TreeMap<>();
	}

	public void put(int id, String timestamp) {
		List<Integer> idList = timeToIdMap.getOrDefault(timestamp, new ArrayList<>());
		idList.add(id);
		timeToIdMap.put(timestamp, idList);
	}

	public List<Integer> retrieve(String s, String e, String gra) {
		List<Integer> ans = new ArrayList<>();

		int graIdx = graMap.get(gra);
		String startTime = s.substring(0, graIdx) + minTimeStamp.substring(graIdx);
		String endTime = e.substring(0, graIdx) + maxTimeStamp.substring(graIdx);

		NavigableMap<String, List<Integer>> subMap = timeToIdMap.subMap(startTime, true, endTime, true);

		for (String timeStamp : subMap.keySet()) {
			ans.addAll(subMap.get(timeStamp));
		}

		return ans;
	}

	public static void main(String[] args) {
		System.out.println(Integer.parseInt("00"));
	}
}

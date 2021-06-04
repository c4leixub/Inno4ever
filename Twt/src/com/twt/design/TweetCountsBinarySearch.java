package com.twt.design;

import java.util.*;

public class TweetCountsBinarySearch {

	// only works if time is insert in ascending order
	private Map<String, List<Integer>> map;
	
	public TweetCountsBinarySearch() {
		map = new HashMap<>();
	}
	
	public void recordEvent(String tweetName, int time) {
		List<Integer> list = map.get(tweetName);
		if(list == null){
            list = new ArrayList<>();
            list.add(time);
            map.put(tweetName, list);
        }else{
			list.add(time);
        }
	}
	
	public List<Integer> getEventCounts(String freq, String tweetName, int startTime, int endTime) {
		List<Integer> res = new ArrayList<>();
		
		List<Integer> list = map.get(tweetName);
		if (list == null || list.isEmpty()) {
			return res;
		}

		int delta = 1;
		if ("minute".equals(freq)) {
			delta = 60;
		} else if ("hour".equals(freq)) {
			delta = 60 * 60;
		} else if ("day".equals(freq)) {
			delta = 24 * 60 * 60;
		}
		
		int s = Collections.binarySearch(list, new Integer(startTime));
		if (s < 0) {
			s = - s - 1;
		}
		
		int e = Collections.binarySearch(list, new Integer(endTime));
		if (e < 0) {
			 e = - e - 2;
		}
		
		int index;
		Integer time;
		for (int i = s; i <= e; i++) {
			time = list.get(i);
			index = (time - startTime) / delta;
			if (index >= res.size()) {
				res.add(0);
			}
			res.set(index, res.get(index) + 1);
		}
		
		return res;
	}
}

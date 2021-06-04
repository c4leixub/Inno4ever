package com.fcb.heap.sort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharByFreq {
	public String frequencySort(String s) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();
	    for (int i = 0; i < s.length(); i++) {
	        map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
	    }
	    
	    PriorityQueue<Character> pq = new PriorityQueue<Character>(new Comparator<Character>() {
			public int compare(Character o1, Character o2) {
			    return map.get(o2) - map.get(o1);
			}
		});
	    
	    for (Character c : map.keySet()) {
	        pq.add(c);
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    while (!pq.isEmpty()) {
	    	Character c = pq.poll();
	    	int t = map.get(c);
	        for (int i = 0; i < t; i++) {
	        	sb.append(c);
	        }
	    }
	    
	    return sb.toString();
	}
}

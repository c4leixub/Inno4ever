package com.zeetcode.stream;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CheckExistInStream {
	
	Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
	Queue<Integer> queue = new LinkedList();
	
	public boolean checkExist(int n, int k) {
		return countMap.containsKey(n);
	}
	
	public void record(int n) {
		if (!countMap.containsKey(n)) {
			countMap.put(n, 0);
		}
		
		countMap.put(n, countMap.get(n)+1);
		
	}
	
	public void remove() {
	}
}

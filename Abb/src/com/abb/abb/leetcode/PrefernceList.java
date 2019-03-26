package com.abb.abb.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class PrefernceList {
	public List<Integer> getPreference(List<List<Integer>> preferences) {
		List<Integer> result = new ArrayList<Integer>();
		
		Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
		Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();
		
		// build graph
		for (List<Integer> preference: preferences) {
			for (int i = 0; i < preference.size() - 1; i++) {
				Integer from = preference.get(i);
				Integer to = preference.get(i+1);
				
				graph.putIfAbsent(from, new HashSet<Integer>());
				indegree.putIfAbsent(from, 0);
				
				graph.putIfAbsent(to, new HashSet<Integer>());
				indegree.putIfAbsent(to, 0);
				
				if (!graph.get(from).contains(to)) {
					graph.get(from).add(to);
					
					indegree.put(to, indegree.get(to)+1);
				}
			}
		}
		
		// topological sort
		Queue<Integer> queue = new LinkedList<Integer>();
		for (Entry<Integer, Integer> entry : indegree.entrySet()) {
			if (entry.getValue() == 0) {
				queue.add(entry.getKey());
			}
		}
		
		Integer cur;
		Set<Integer> set;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			result.add(cur);
			
			set = graph.get(cur);
			for (Integer e : set) {
				int val = indegree.get(e)-1;
				indegree.put(e, val);
				if (val == 0) {
					queue.add(e);
				}
			}
		}
        
        return result;
	}
	
	public static void main(String[] args) {
		PrefernceList p = new PrefernceList();
		
		List<List<Integer>> preferences = new ArrayList<List<Integer>>();
		
		preferences.add(new ArrayList<Integer>());
		int last = preferences.size()-1;
		preferences.get(last).add(3);
		preferences.get(last).add(5);
		preferences.get(last).add(7);
		preferences.get(last).add(9);
		
		
		preferences.add(new ArrayList<Integer>());
		last = preferences.size()-1;
		preferences.get(last).add(2);
		preferences.get(last).add(3);
		preferences.get(last).add(8);
		
		
		preferences.add(new ArrayList<Integer>());
		last = preferences.size()-1;
		preferences.get(last).add(5);
		preferences.get(last).add(8);
		
		System.out.println(p.getPreference(preferences));
	}
}

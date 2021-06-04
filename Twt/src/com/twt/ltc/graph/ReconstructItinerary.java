package com.twt.ltc.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class ReconstructItinerary {

	public List<String> findItinerary(String[][] tickets) {

		Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
		for (int i = 0; i < tickets.length; i++) {
			if (!map.containsKey(tickets[i][0])) {
				map.put(tickets[i][0], new PriorityQueue<String>());
			}
			map.get(tickets[i][0]).add(tickets[i][1]);
		}

		List<String> res = new ArrayList<String>();

		String cur = "JFK";
//        Stack<String> stack = new Stack<String>();
//        stack.add(cur);
//        while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
//        	stack.add(map.get(stack.peek()).poll());
//        }
//        
//        while (!stack.isEmpty()) {
//        	cur = stack.pop();
//        	res.add(cur);
//        	if (map.containsKey(cur) && !map.get(cur).isEmpty()) {
//        		stack.add(map.get(cur).poll());
//        		while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
//                	stack.add(map.get(stack.peek()).poll());
//                }
//        	}
//        }

		dfs(cur, map, res);

		Collections.reverse(res);
		return res;

	}

	public static void main(String[] args) {
		String[][] tickets = new String[][] { { "MUC", "LHR" }, { "JFK", "MUC" }, { "SFO", "SJC" }, { "LHR", "SFO" } };
		// tickets = new String[][]
		// {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		tickets = new String[][] { { "JFK", "KUL" }, { "JFK", "NRT" }, { "NRT", "JFK" } };
		ReconstructItinerary r = new ReconstructItinerary();
		System.out.println(r.findItinerary(tickets));
	}

	public void dfs(String cur, Map<String, PriorityQueue<String>> hashmap, List<String> list) {
		while (hashmap.containsKey(cur) && !hashmap.get(cur).isEmpty()) {
			dfs(hashmap.get(cur).poll(), hashmap, list);
		}
		list.add(cur);
	}
}

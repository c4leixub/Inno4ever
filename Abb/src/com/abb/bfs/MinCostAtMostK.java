package com.abb.bfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MinCostAtMostK {
	
	/**
	 * A->B, 100,
	 * B->C, 100,
	 * A->C, 500.
	 */
	@SuppressWarnings("unlikely-arg-type")
	public int minCost(List<String> lines, String source, String target, int k) {
		
		Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>();
		for (String line : lines) {
			String[] s = line.trim().split(",");
			String[] t = s[0].trim().split("->");
			
			String from = t[0];
			String to = t[1];
			int cost = Integer.valueOf(s[1].trim());
			
			map.putIfAbsent(from, new HashMap<String, Integer>());
			map.putIfAbsent(to, new HashMap<String, Integer>());
			
			map.get(from).put(to, cost);
		}
		
		int min = Integer.MAX_VALUE, stop = 0;
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(source, 0));
		
		while (!q.isEmpty()) {
			if (stop > k) {
				break;
			}
			
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node cur = q.poll();
				String dest = cur.dest;
				int currCost = cur.minCost;
				
				if (dest.equals(target)) {
					min = Math.min(min, currCost);
				}
				
				for (String next : map.get(dest).keySet()) {
					int nextCost = currCost + map.get(dest).get(next);
					//if (nextCost <= min) {
						q.add(new Node(next, nextCost));
					//}
				}
			}
			stop++;
		}
		
		return min != Integer.MAX_VALUE ? min : -1;
	}
	
	class Node {
		String dest;
		int minCost;
		public Node(String dest, int minCost) {
			this.dest = dest;
			this.minCost = minCost;
		}
	}
	
	public static void main(String[] args) {
		List<String> lines = Arrays.asList("A->B, 100", "B->C, 100", "A->C, 500");
		MinCostAtMostK m = new MinCostAtMostK();
		System.out.println(m.minCost(lines, "A", "C", 2));
	}
}

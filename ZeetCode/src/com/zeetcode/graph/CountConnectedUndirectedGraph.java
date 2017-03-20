package com.zeetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountConnectedUndirectedGraph {

	public int countComponents(int n, int[][] edges) {
		if (n <= 1)
			return n;

		// construct the graph
		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		for (int i = 0; i < n; i++) {
			map.put(i, new HashSet<Integer>());
		}
		for (int[] edge : edges) {
			map.get(edge[0]).add(edge[1]);
			map.get(edge[1]).add(edge[0]);
		}

		int count = 0;
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(i, map, visited);
				count++;
			}
		}

		return count;

	}

	public void dfs(Integer i, Map<Integer, Set<Integer>> map, boolean[] visited) {
		if (visited[i]) return;

		visited[i] = true;
		for (Integer k : map.get(i)) {
			dfs(k, map, visited);
		}

	}
	
	public static void main(String[] args) {
		int n = 5;
		int[][] edges = new int[][] {{0,1},{1,2},{3,4}};
		
		CountConnectedUndirectedGraph c = new CountConnectedUndirectedGraph();
		System.out.println(c.countComponents(n, edges));
	}
}

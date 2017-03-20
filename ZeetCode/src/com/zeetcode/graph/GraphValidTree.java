package com.zeetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each
 * edge is a pair of nodes), check if these edges form a valid tree.
 */
public class GraphValidTree {
	public boolean validTreeDFS(int n, int[][] edges) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			map.put(i, list);
		}

		for (int[] edge : edges) {
			map.get(edge[0]).add(edge[1]);
			map.get(edge[1]).add(edge[0]);
		}

		boolean[] visited = new boolean[n];

		if (!helper(0, -1, map, visited))
			return false;

		for (boolean b : visited) {
			if (!b)
				return false;
		}

		return true;
	}

	public boolean helper(int curr, int parent,
			HashMap<Integer, ArrayList<Integer>> map, boolean[] visited) {
		if (visited[curr])
			return false;

		visited[curr] = true;

		for (int i : map.get(curr)) {
			if (i != parent && !helper(i, curr, map, visited)) {
				return false;
			}
		}

		return true;
	}

	public boolean validTreeBFS(int n, int[][] edges) {
		Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
		for (int[] edge : edges) {
			if (!graph.containsKey(edge[0])) {
				graph.put(edge[0], new HashSet<Integer>());
			}
			graph.get(edge[0]).add(edge[1]);

			if (!graph.containsKey(edge[1])) {
				graph.put(edge[1], new HashSet<Integer>());
			}
			graph.get(edge[1]).add(edge[0]);
		}

		Set<Integer> visited = new HashSet<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);

		while (!queue.isEmpty()) {
			Integer e = queue.poll();
			if (visited.contains(e)) {
				return false;
			}
			visited.add(e);

			if (graph.containsKey(e)) {
				for (Integer c : graph.get(e)) {
					if (!visited.contains(c)) {
						queue.add(c);
					}
				}
			}
		}

		return visited.size() == n;
	}
}

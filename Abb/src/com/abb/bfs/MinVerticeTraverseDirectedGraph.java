package com.abb.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a directed graph, represented in a two dimension array, output a list
 * of points that can be used to traverse every points with the least number of
 * visited vertices.
 */
public class MinVerticeTraverseDirectedGraph {
	public List<Integer> getMin(int[][] edges, int n) {
		Map<Integer, Set<Integer>> nodes = new HashMap<>();
		for (int i = 0; i < n; i++) {
			nodes.put(i, new HashSet<>());
		}
		for (int[] edge : edges) {
			nodes.get(edge[0]).add(edge[1]);
		}

		Set<Integer> visited = new HashSet<>();
		Set<Integer> res = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (!visited.contains(i)) {
				res.add(i);
				visited.add(i);
				dfs(res, nodes, i, i, visited, new HashSet<>());
			}
		}

		return new ArrayList<>(res);
	}

	private void dfs(Set<Integer> res, Map<Integer, Set<Integer>> nodes, int cur, int start, Set<Integer> visited,
			Set<Integer> currVisited) {
		
		currVisited.add(cur);
		visited.add(cur);
		for (int next : nodes.get(cur)) {
			if (res.contains(next) && next != start) {
				res.remove(next);
			}
			if (!currVisited.contains(next)) {
				dfs(res, nodes, next, start, visited, currVisited);
			}
		}
	}
	
	public static void main(String[] args) {
		MinVerticeTraverseDirectedGraph sol = new MinVerticeTraverseDirectedGraph();
		
		int[][] edges = {{0, 0}, {1, 2}, {2, 0}, {2, 3}, {3, 1}};
        List<Integer> res = sol.getMin(edges, 4);
        System.out.println(res);
        
        edges = new int[][]{{2, 9}, {3, 3}, {3, 5}, {3, 7}, {4, 8}, {5, 8}, {6, 6}, {7, 4}, {8, 7}, {9, 3}, {9, 6}};
        res = sol.getMin(edges, 10);
        System.out.println(res);
	}
}

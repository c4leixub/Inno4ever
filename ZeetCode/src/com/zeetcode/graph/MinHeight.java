package com.zeetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinHeight {

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n <= 0) {
			return new ArrayList<>();
		}

		// Corner case: there is a single node and no edge at all
		if (n == 1 && edges.length == 0) {
			return Arrays.asList(0);
		}

		// Step 1: construct the graph
		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		for(int i = 0; i < n; i++){ 
			map.put(i, new HashSet<Integer>());
		}
		for (int[] edge : edges) {
			map.get(edge[0]).add(edge[1]);
			map.get(edge[1]).add(edge[0]);
		}

		// Step 2: Find the initial leaves
		List<Integer> leaves = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (map.get(i).size() == 1) {
				leaves.add(i);
			}
		}

		// Step 3: identify and remove all leaf nodes
		while (n > 2) {
			n -= leaves.size();
			List<Integer> newLeaves = new ArrayList<>();
			for (int leaf : leaves) {
				int neighbor = map.get(leaf).iterator().next();
				map.get(neighbor).remove(leaf);
				
				if (map.get(neighbor).size() == 1) {
					newLeaves.add(neighbor);
				}
			}

			leaves = newLeaves;
		}

		return leaves;
    }
	
	public static void main(String[] args) {
		int n = 6;
		int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		MinHeight m = new MinHeight();
		System.out.println(m.findMinHeightTrees(n, edges));
	}
}

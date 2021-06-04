package com.twt.ltc.graph.topo;

import java.util.*;

public class CourseSchedule {
	public int[] findOrder(int numCourses, int[][] prerequisites) {

		Map<Integer, List<Integer>> adjList = new HashMap<>();
		int[] indegree = new int[numCourses];

		for (int i = 0; i < prerequisites.length; i++) {
			int dest = prerequisites[i][0];
			int src = prerequisites[i][1];

			List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
			lst.add(dest);
			adjList.put(src, lst);

			indegree[dest] += 1;
		}

		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

		int i = 0;
		int[] topologicalOrder = new int[numCourses];
		while (!q.isEmpty()) {
			int node = q.poll();
			topologicalOrder[i++] = node;

			if (adjList.containsKey(node)) {
				for (Integer neighbor : adjList.get(node)) {
					indegree[neighbor]--;

					if (indegree[neighbor] == 0) {
						q.add(neighbor);
					}
				}
			}
		}

		return (i == numCourses) ? topologicalOrder : new int[0];
	}
}

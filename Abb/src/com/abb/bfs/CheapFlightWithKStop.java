package com.abb.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class CheapFlightWithKStop {

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

		Map<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();
		for (int[] flight : flights) {
			map.putIfAbsent(flight[0], new ArrayList<int[]>());
			map.get(flight[0]).add(new int[] { flight[1], flight[2] });
		}

		int min = Integer.MAX_VALUE;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { src, 0 });
		int steps = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			while (size > 0) {
				int[] node = q.poll();
				int curr = node[0], cost = node[1];

				if (curr == dst) {
					min = Math.min(min, cost);
				}

				if (map.containsKey(curr)) {
					for (int[] dest : map.get(curr)) {
						if (cost + dest[1] > min)
							continue;

						q.add(new int[] { dest[0], cost + dest[1] });
					}
				}
				size--;
			}

			if (steps > K) {
				break;
			} else {
				steps++;
			}
		}

		return min != Integer.MAX_VALUE ? min : -1;
	}

	public static void main(String[] args) {
		int n = 3;
		int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
		int src = 0;
		int dst = 2;
		int K = 1;

		CheapFlightWithKStop cf = new CheapFlightWithKStop();
		System.out.println(cf.findCheapestPrice(n, flights, src, dst, K));
	}

	/**
	 * Time Complexity: O(E+nlogn), where E is the total number of flights. Space
	 * Complexity: O(n), the size of the heap.
	 */
	public int findCheapestPriceD(int n, int[][] flights, int src, int dst, int K) {

		int[][] graph = new int[n][n];
		for (int[] flight : flights) {
			graph[flight[0]][flight[1]] = flight[2];
		}

		Map<Integer, Integer> best = new HashMap<>();

		Queue<int[]> pq = new PriorityQueue<int[]>();
		pq.add(new int[] { 0, 0, src });

		while (!pq.isEmpty()) {
			int[] info = pq.poll();
			int cost = info[0], k = info[1], place = info[2];

			if (k > K + 1 || cost > best.getOrDefault(k * 1000 + place, Integer.MAX_VALUE))
				continue;

			if (place == dst)
				return cost;

			for (int nei = 0; nei < n; ++nei) {
				if (graph[place][nei] == 0)
					continue;

				int newcost = cost + graph[place][nei];
				if (newcost < best.getOrDefault((k + 1) * 1000 + nei, Integer.MAX_VALUE)) {
					pq.offer(new int[] { newcost, k + 1, nei });
					best.put((k + 1) * 1000 + nei, newcost);
				}
			}
		}

		return -1;
	}
}

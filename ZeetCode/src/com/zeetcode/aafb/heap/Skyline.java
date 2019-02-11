package com.zeetcode.aafb.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Skyline {
	public List<int[]> getSkyline(int[][] buildings) {

		List<int[]> edges = new ArrayList<int[]>();
		for (int i = 0; i < buildings.length; i++) {
			edges.add(new int[] { buildings[i][0], buildings[i][2] });
			edges.add(new int[] { buildings[i][1], -buildings[i][2] });
		}

		Collections.sort(edges, new Comparator<int[]>() {
			public int compare(int[] e1, int[] e2) {
				if (e1[0] == e2[0]) {
					return e2[1] - e2[1];
				}

				return e1[0] - e2[0];
			}
		});

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());
		List<int[]> res = new ArrayList<int[]>();
		for (int[] e : edges) {
			int x = e[0], h = e[1];// , idx = e[2];
			if (h > 0) {
				if (maxHeap.isEmpty() || h > maxHeap.peek()) {
					res.add(new int[] { x, h });
				}
				maxHeap.add(h);
			} else {
				h = Math.abs(h);
				maxHeap.remove(h);

				if (maxHeap.isEmpty()) {
					res.add(new int[] { x, 0 });
				} else if (h > maxHeap.peek()) {
					res.add(new int[] { x, maxHeap.peek() });
				}
			}
		}

		return res;
	}
}

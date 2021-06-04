package com.lkin.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairs {
	public List<List<Integer>> kSmallestPairs(final int[] nums1, final int[] nums2, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k == 0) {
			return result;
		}

		// array in the queue is index pair
		PriorityQueue<int[]> heap = new PriorityQueue<int[]>(k, new Comparator<int[]>() {
			public int compare(int[] p1, int[] p2) {
				return (nums1[p1[0]] + nums2[p1[1]]) - (nums1[p2[0]] + nums2[p2[1]]);
			}
		});
		
		for (int i = 0; i < nums1.length; i++) {
			heap.add(new int[] { i, 0});
		}
		
		while (!heap.isEmpty() && result.size() < k) {
			int[] p = heap.poll();
			result.add(Arrays.asList(new Integer(nums1[p[0]]), new Integer(nums2[p[1]])));
			
			if (p[1] + 1 < nums2.length) {
				heap.add(new int[] { p[0], p[1] + 1 });
			}
		}
		
		/*
		boolean[][] visited = new boolean[nums1.length][nums2.length];

		heap.add(new int[] { 0, 0 });
		visited[0][0] = true;

		while (!heap.isEmpty() && result.size() < k) {	// K
			int[] p = heap.poll();
			result.add(Arrays.asList(new Integer(nums1[p[0]]), new Integer(nums2[p[1]])));
			//result.add(new int[] { nums1[p[0]], nums2[p[1]] });

			if (p[0] + 1 < nums1.length && !visited[p[0] + 1][p[1]]) {
				heap.add(new int[] { p[0] + 1, p[1] });	// log K
				visited[p[0] + 1][p[1]] = true;
			}

			if (p[1] + 1 < nums2.length && !visited[p[0]][p[1] + 1]) {
				heap.add(new int[] { p[0], p[1] + 1 });	// log K
				visited[p[0]][p[1] + 1] = true;
			}
		}
		*/

		return result; // KlogK, K
	}
}

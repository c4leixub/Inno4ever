package com.fcb.heap.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsSmallestSums {
	
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		
		List<List<Integer>> result = new ArrayList<>();
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k == 0) {
			return result;
		}
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]);
			}
			
		});
		
		boolean[][] visited = new boolean[nums1.length][nums2.length];
		
		pq.add(new int[] {0, 0});
        visited[0][0] = true;
		
		int[] p;
		while (!pq.isEmpty() && result.size() < k) {
			p = pq.poll();
			result.add(Arrays.asList(new Integer(nums1[p[0]]), new Integer(nums2[p[1]])));
			
			if (p[0] + 1 < nums1.length && !visited[p[0] + 1][p[1]]) {
				pq.add(new int[] { p[0] + 1, p[1] });
                visited[p[0] + 1][p[1]] = true;
			}
			
			if (p[1] + 1 < nums2.length && !visited[p[0]][p[1] + 1]) {
				pq.add(new int[] { p[0], p[1] + 1 });
                visited[p[0]][p[1] + 1] = true;
			}
		}
		
		return result;
	}
}

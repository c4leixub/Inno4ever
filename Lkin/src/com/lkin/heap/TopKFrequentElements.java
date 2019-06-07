package com.lkin.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> result = new LinkedList<Integer>();
		if (nums == null || nums.length == 0 || k == 0) {
			return result;
		}

		// O(N)
		final Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
		for (Integer num : nums) {
			counts.put(num, counts.getOrDefault(num, 0) + 1);
		}

		// O(n log k)
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return counts.get(o1) - counts.get(o2);
			}
		});

		for (Integer num : counts.keySet()) {
			heap.add(num);
			if (heap.size() > k) {
				heap.poll();
			}
		}

		while (!heap.isEmpty()) {
			result.add(heap.poll());
		}
		Collections.reverse(result);

		return result;

	}
}

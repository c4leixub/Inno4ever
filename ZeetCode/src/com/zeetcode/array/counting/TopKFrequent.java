package com.zeetcode.array.counting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequent {

	public List<Integer> topKFrequent(int[] nums, int k) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int a : nums) {
			if (map.containsKey(a)) {
				map.put(a, map.get(a) + 1);
			} else {
				map.put(a, 1);
			}
		} // O(n)

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k,
				new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return map.get(o1) - map.get(o2);
					}
				});
		for (Integer e : map.keySet()) {
			if (queue.size() < k) {
				queue.add(e); // O(log k)
			} else {
				int least = map.get(queue.peek());
				if (map.get(e) > least) {
					queue.poll();
					queue.add(e);
				}
			}
		} // O(n * log k)

		List<Integer> result = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			result.add(queue.poll());
		}
		Collections.reverse(result); // O(k)

		return result;

	}
}

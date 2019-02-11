package com.lkin.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthElementInArray {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});

		// O(N log K)
		for (int num : nums) {
			if (heap.size() < k) {
				heap.add(num);
			} else {
				if (num > heap.peek()) {
					heap.poll();
					heap.add(num);
				}
			}
		}

		return heap.peek();
	}
}

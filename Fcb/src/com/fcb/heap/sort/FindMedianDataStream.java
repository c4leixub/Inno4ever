package com.fcb.heap.sort;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianDataStream {

	public class MedianFinder {
		
		private PriorityQueue<Integer> lower;	//	max heap
		private PriorityQueue<Integer> higher;	// min heap
		
		public MedianFinder() {
			lower = new PriorityQueue<Integer>(Collections.reverseOrder());
			higher = new PriorityQueue<Integer>();
		}

		public void addNum(int num) {
			lower.add(num);
			higher.add(lower.poll());
			
			if (lower.size() < higher.size()) {
				lower.add(higher.poll());
			}
		}

		public double findMedian() {
			return lower.size() > higher.size() ? lower.peek() : (lower.peek() + higher.peek()) / 2.0;
		}
	}
}

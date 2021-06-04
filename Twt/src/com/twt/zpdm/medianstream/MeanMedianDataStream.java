package com.twt.zpdm.medianstream;

import java.util.Collections;
import java.util.PriorityQueue;

public class MeanMedianDataStream {

	public class MedianFinder {

		private PriorityQueue<Integer> lower; // max heap
		private PriorityQueue<Integer> higher; // min heap

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

	private double sum;
	private int count;
	private MedianFinder medianFinder;

	public MeanMedianDataStream() {
		sum = 0.0;
		count = 0;
		medianFinder = new MedianFinder();
	}

	public void addNum(int num) {
		sum += num;
		count++;
		medianFinder.addNum(num);
	}

	public double findMean() {
		return sum / count;
	}

	public double findMedian() {
		return this.medianFinder.findMedian();
	}
}

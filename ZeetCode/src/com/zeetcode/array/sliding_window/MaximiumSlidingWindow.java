package com.zeetcode.array.sliding_window;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaximiumSlidingWindow {

	public int[] maxSlidingWindowDeque(int[] nums, int k) {
		if (nums.length == 0 || k == 1)
			return nums;

		int[] max = new int[nums.length - k + 1];

		// the queue stores the indexes
		LinkedList<Integer> deque = new LinkedList<Integer>();

		for (int i = 0; i < nums.length; i++) {
			// remove the 1st element in queue if it's the left edge of window
			if (!deque.isEmpty() && deque.peekFirst() == i - k) {
				deque.pollFirst();
			}

			// remove element at the back if smaller than current one
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.removeLast();
			}

			deque.addLast(i);

			if (i + 1 >= k) {
				max[i + 1 - k] = nums[deque.peek()];
			}
		}

		return max;
	}

	public static void main(String[] args) {
		MaximiumSlidingWindow m = new MaximiumSlidingWindow();
		List<Integer> list = new ArrayList<Integer>();
		int[] re = m.maxSlidingWindowDeque(new int[] { 5, 4, 3, 2, 1, 0 }, 3);
		for (int i : re) {
			list.add(i);
		}
		System.out.println(list);
	}
}

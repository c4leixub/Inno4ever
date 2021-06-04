package com.fcb.heap.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestInArray {
	public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}	
        });
        
        for (int num : nums) {
        	pq.add(num);
			if (pq.size() > k) {
				pq.poll();
			}
        }
        
        return pq.peek();
    } 
}

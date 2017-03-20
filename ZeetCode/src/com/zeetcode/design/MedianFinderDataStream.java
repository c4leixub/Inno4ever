package com.zeetcode.design;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MedianFinderDataStream {
	
	private PriorityQueue<Integer> maxHeap;//lower half
    private PriorityQueue<Integer> minHeap;//higher half

    public MedianFinderDataStream(){
    	// Collections.reverseOrder() returns Comparator for reverse order
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        
        maxHeap.add(num);
    	minHeap.add(maxHeap.poll());
    	
    	if (maxHeap.size() < minHeap.size()) {
    		maxHeap.add(minHeap.poll());
    	}
        
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxHeap.size() == 0) return 0.0;
        
        if (maxHeap.size() == minHeap.size()) {
        	return (double)(maxHeap.peek()+(minHeap.peek()))/2;
        }
        
        return maxHeap.peek();
    }
}

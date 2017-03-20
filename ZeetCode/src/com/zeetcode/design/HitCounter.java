package com.zeetcode.design;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {
	
	private Queue<Integer> queue;
    private static final int FIVE_MINS = 300;

    /** Initialize your data structure here. */
    public HitCounter() {
        queue = new LinkedList<Integer>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.add(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int s = timestamp - FIVE_MINS;
        while (queue.peek() != null && queue.peek().intValue() <= s) {
            queue.poll();
        } 
        
        return queue.size();
    }
}

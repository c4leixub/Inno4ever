package com.zeetcode.design;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageDataStream {
	
	Queue<Integer> queue;
    int sum;
    int size;
    
    /** Initialize your data structure here. */
    public MovingAverageDataStream(int size) {
        queue = new LinkedList<Integer>();
        sum = 0;
        this.size = size;
    }
    
    public double next(int val) {
        queue.add(val);
        sum += val;
        
        int v = 0;
        if (queue.size() > size) {
            v = queue.poll().intValue();
        }
        sum -= v;
        
        return ((double) sum) / queue.size();
    }
    
}

package com.zeetcode.systemDesign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsistentHashing {
	/*
     * @param n: a positive integer
     * @return: n x 3 matrix
     * 
     * If the maximal interval is [x, y], and it belongs to machine id z, 
     * when you add a new machine with id n, you should divide [x, y, z] into two intervals:
     * [x, (x + y) / 2, z] and [(x + y) / 2 + 1, y, n]
     */
    public List<List<Integer>> consistentHashing(int n) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n == 1) {
        	result.add(Arrays.asList(new Integer(0), new Integer(359), new Integer(1)));
        	return result;
        }
        
        List<List<Integer>> pre = consistentHashing(n-1);
        int maxIndex = getMaxInteval(pre);
        for (int i = 0; i < pre.size(); i++) {
        	if (maxIndex == i) {
        		int x = pre.get(i).get(0), y = pre.get(i).get(1), z = pre.get(i).get(2);
        		result.add(Arrays.asList(new Integer(x), new Integer((x+y)/2), new Integer(z)));
        		result.add(Arrays.asList(new Integer((x+y)/2+1), new Integer(y), new Integer(n)));
        	} else {
        		result.add(pre.get(i));
        	}
        }
        return result;
    }
    
    private int getMaxInteval(List<List<Integer>> intervals) {
    	if (intervals.isEmpty()) {
    		return -1;
    	}
    	
    	int re = 0;
    	int max = intervals.get(0).get(1)-intervals.get(0).get(0);
    	int len;
    	for (int i = 1; i < intervals.size(); i++) {
    		len = intervals.get(i).get(1)-intervals.get(i).get(0);
    		if (len > max) {
    			re = i;
    			max = len;
    		}
    	}
    	
    	return re;
    }
}

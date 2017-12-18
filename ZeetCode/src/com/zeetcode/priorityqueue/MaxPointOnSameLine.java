package com.zeetcode.priorityqueue;

import java.util.HashMap;

public class MaxPointOnSameLine {
	public int maxPoints(Point[] points) {
        if (points == null || points.length == 0)   return 0;
        if (points.length == 1) return 1;
        
        HashMap<Double, Integer> result = new HashMap<Double, Integer>();
        int max = 1;
        
        for (int i = 0; i < points.length; i++) {
            int duplicate = 0, vertical = 1;
        	
        	for (int j = i+1; j < points.length; j++) {
        		
        		// handle duplicate and vertical slope
        		if (points[i].x == points[j].x) {
        			if (points[i].y == points[j].y) {
        				duplicate++;
        			} else {
        				vertical++;
        			}
        		} else {
	        		Double slope = slope(points[i], points[j]);
	                if (result.containsKey(slope)) {
	                	result.put(slope, result.get(slope) + 1);
	                } else {
	                	result.put(slope, 2);
	                }
        		}
                
            }
        	
        	// find the max for points[i]
        	for (Integer count : result.values()) {
        		max = Math.max(count + duplicate, max);
        	}
        	max = Math.max(vertical + duplicate, max);
        	
        	result.clear();
        }
        
        return max;
    }
    
    public Double slope(Point p1, Point p2) {        
        return 0.0 + (double) (p2.y-p1.y) / (double) (p2.x-p1.x);
    }
    
    public static void main(String[] args) {
    	MaxPointOnSameLine m = new MaxPointOnSameLine();
    	Point[] points = new Point[] {	new Point(2,2), new Point(1,1), new Point(2,2),};
    	System.out.println(m.maxPoints(points));
    }
}

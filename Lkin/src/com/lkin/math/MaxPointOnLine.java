package com.lkin.math;

import java.util.HashMap;
import java.util.Map;

public class MaxPointOnLine {

	public class Point {
		public int x;
		public int y;
	}

	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0)
			return 0;
		if (points.length == 1)
			return 1;
        
        int max = 1;
        
        for (int i = 0; i < points.length; ++i) {
            Map<String, Integer> slopeMap = new HashMap<String, Integer>();
            
            int duplicate = 0; // points are same as point[i]
            int vertical = 0; // points are vertical of point[i]
            
            // for j > i, max points on the same line with point[i]  
            int maxPoints = 0; 
			for (int j = i + 1; j < points.length; ++j) {
                
				if (points[i].x == points[j].x) {
					// handle duplicate and vertical slope
                    if (points[i].y == points[j].y) {
						duplicate++;
					} else {
						vertical++;
					}
				} else {
					String slope = slope(points[i], points[j]);
                    slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                    
                    maxPoints = Math.max(maxPoints, slopeMap.get(slope));
				}
            }    
            maxPoints = Math.max(maxPoints, vertical);
            
            max = Math.max(maxPoints + duplicate + 1, max);
        }
        
        return max;
    }
    
    private String slope(Point p1, Point p2) {
		int dx = p2.x - p1.x;
		int dy = p2.y - p1.y;
		int d = gcd(dx, dy);

		// the slope in fraction form
		StringBuilder s = new StringBuilder();
		s.append(dy/d);
		s.append('/');
		s.append(dx/d);

		return s.toString();
	}
    
    private int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, a % b);
	}
}

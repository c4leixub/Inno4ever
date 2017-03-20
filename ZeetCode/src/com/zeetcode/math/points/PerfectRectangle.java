package com.zeetcode.math.points;

import java.util.HashSet;
import java.util.Set;

public class PerfectRectangle {
	
	/**
	 * Match condition
	 * 
	 * 1. The sum of area of all small rectangles should equal to the area of large rectangle.
	 * 
	 * 2. For each small rectangle, add all four corner to the a set. If the corner already in
	 * the set, remove it. If there is not overlap, then the set will only have 4 corner of
	 * the large rectangle.
	 */
	public boolean isRectangleCover(int[][] rectangles) {
        
        int totalArea = 0;
        int[] rec = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE,
                                Integer.MIN_VALUE, Integer.MIN_VALUE};
                                
        Set<String> set = new HashSet<String>();
        
        String p1, p2, p3, p4;
        for (int[] r : rectangles) {
            totalArea += ((r[2]-r[0]) * (r[3]-r[1]));
            
            rec[0] = Math.min(rec[0], r[0]);
            rec[1] = Math.min(rec[1], r[1]);
            rec[2] = Math.max(rec[2], r[2]);
            rec[3] = Math.max(rec[3], r[3]);
            
            p1 = r[0]+" "+r[1];
            p2 = r[0]+" "+r[3];
            p3 = r[2]+" "+r[3];
            p4 = r[2]+" "+r[1];
            
            if (!set.add(p1)) set.remove(p1);
            if (!set.add(p2)) set.remove(p2);
            if (!set.add(p3)) set.remove(p3);
            if (!set.add(p4)) set.remove(p4);
        }
        
        p1 = rec[0]+" "+rec[1];
        p2 = rec[0]+" "+rec[3];
        p3 = rec[2]+" "+rec[3];
        p4 = rec[2]+" "+rec[1];
        
        if (!set.contains(p1) || !set.contains(p2)
                || !set.contains(p3) || !set.contains(p4) || set.size() != 4) {
            return false;       
        }
        
        return ((rec[2]-rec[0]) * (rec[3]-rec[1]) - totalArea) == 0;
    }
}

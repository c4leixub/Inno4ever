package com.zeetcode.math.points;

import java.util.HashMap;
import java.util.Map;

public class Boomerangs {
	public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int d = distance(points[i], points[j]);
                    map.put(d, map.getOrDefault(d, 0)+1);
                }
            }
            
            for (Integer d : map.keySet()) {
                if (map.get(d) > 1) {
                    // we have map.get(d)=k points with the same distance
                    // k permute 2 pair = k * (k-1)
                    result += map.get(d) * (map.get(d)-1);
                }
            }
        }
        
        return result;
    }
    
    public int distance(int[] p1, int[] p2) {
        int x = p1[0] - p2[0];
        int y = p1[1] - p2[1];
        return x*x + y*y;   // we can do it without square root
    }
}

package com.abb.abb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CheapFlightWithKStop {
	
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
     
        Map<Integer, List<int[]>> map = buildMap(flights);
      
        int min = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] {src, 0});
        int steps = 0;
        
        while (!q.isEmpty()) {
        	int size = q.size();
        	while (size > 0) {
        		int[] node = q.poll();
        		int curr = node[0], cost = node[1];
        		
        		if (curr == dst) {
        			min = Math.min(min, cost);
        		}
        		
        		if (map.containsKey(curr)) {
	        		for (int[] dest : map.get(curr)) {
	        			if (cost + dest[1] > min) continue;
	        			
	        			q.add(new int[] {dest[0], cost+dest[1]});
	        		}
        		}
        		size--;
        	}
        	
        	if (steps > K) {
                break;
            } else {
                steps++;
            }
        }
        
        return min != Integer.MAX_VALUE ? min : -1;
    }
	
	private Map<Integer, List<int[]>> buildMap(int[][] flights) {
		Map<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();
		for (int[] flight : flights) {
			if (!map.containsKey(flight[0])) {
				map.put(flight[0], new ArrayList<int[]>());
			}
			
			map.get(flight[0]).add(new int[] {flight[1], flight[2]});
		}
		
		return map;
	}
	
	public static void main(String[] args) {
		int n = 3;
		int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
		int src = 0;
		int dst = 2;
		int K = 1;
		
		CheapFlightWithKStop cf = new CheapFlightWithKStop();
		System.out.println(
				cf.findCheapestPrice(n, flights, src, dst, K));
	}
}

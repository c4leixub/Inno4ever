package com.zeetcode.binaryIndexandsegmenttree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/** Given a array of building define as [Li, Ri, Hi]
 */
public class Skyline {
	
	class Edge implements Comparable<Edge>{
		int x;
		int value;
		public Edge (int x, int value) {
			this.x = x;
			this.value = value;
		}
		@Override
		public int compareTo(Edge o) {
			if (this.x == o.x) {
				return this.value - o.value;
			}
			return this.x - o.x; 
			
//			if (this.x != o.x)
//				return Integer.compare(this.x, o.x);
//			
//			if (this.value >= 0 && o.value >= 0)
//				return Integer.compare(o.value, this.value);
//			
//			if (this.value < 0 && o.value < 0)
//				return Integer.compare(o.value, this.value);
//			
//			return this.value >= 0 ? -1 : 1;
		}
	}
	
	public List<int[]> getSkyline(int[][] buildings) {
        
		// Step1: convert to Edges (Li -> Hi, Ri -> -Hi) and sort
		List<Edge> edges = new ArrayList<Edge>();
        for (int[] building : buildings) {
        	edges.add(new Edge(building[0], building[2]));
        	edges.add(new Edge(building[1], -building[2]));
        }
        
        // Step2: sort Edges
        Collections.sort(edges);
        
        // Step3: process Edges
        List<int[]> result = new ArrayList<int[]>();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(10, Collections.reverseOrder());
        for (Edge e : edges) {
        	if (e.value > 0) {
        		queue.add(e.value);
        	} else {
        		queue.remove(-1 * e.value);
        	}
        	
        	if (queue.isEmpty()) {
        		result.add(new int[]{e.x, 0});
        	} else {
        		result.add(new int[]{e.x, queue.peek()});
        	}
        	
//        	if (e.value > 0) {
//        		if (queue.isEmpty() || e.value > queue.peek()) {
//        			result.add(new int[]{e.x, e.value});
//        		}
//        		queue.add(e.value);
//        	} else {
//        		queue.remove(-e.value);
//        		
//        		if (queue.isEmpty()) {
//        			result.add(new int[]{e.x, 0});
//        		} else if (-e.value > queue.peek()) {
//        			result.add(new int[]{e.x, queue.peek()});
//        		}
//        	}
        }
        
        // merge
        List<int[]> output = new ArrayList<int[]>();
        if (result.size() > 0) {
        	output.add(result.get(0));
        	int i = 1;
        	while (i < result.size()) {
        		if (output.get(output.size()-1)[1]
        				!= result.get(i)[1]) {
        			output.add(result.get(i));
        		}
        		i++;
        	}
        }
   
        return output;
    }
}

package com.fcb.heap.sort;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

	class Point implements Comparable<Point> {

		public int[] point;
		public double distanceToOrigin;
		
		public Point(int[] point) {
			this.point = point;
			distanceToOrigin = Math.sqrt(Math.pow(point[0], 2.0)+ Math.pow(point[1], 2.0));
		}
		
		@Override
		public int compareTo(Point o) {
			if (this.distanceToOrigin > o.distanceToOrigin) {
				return -1;
			} else if (this.distanceToOrigin < o.distanceToOrigin) {
				return 1;
			}
			
			return 0;
		}
		
	}
	
	public int[][] kClosest(int[][] points, int K) {
        
        int[][] res = new int[K][2];
        PriorityQueue<Point> pq = new PriorityQueue<>();
        
        double distanceToOrigin;
        for (int[] point : points) {
        	if (pq.size() < K) {
        		pq.add(new Point(point));
        	} else {
        		distanceToOrigin = Math.sqrt(Math.pow(point[0], 2.0)+ Math.pow(point[1], 2.0));
        		if (distanceToOrigin < pq.peek().distanceToOrigin) {
        			pq.poll();
        			pq.add(new Point(point));
        		}
        	}
        }
        
        for (int i = 0; i < K; i++) {
        	res[i] = pq.poll().point;
        }
        return res;
    }
}

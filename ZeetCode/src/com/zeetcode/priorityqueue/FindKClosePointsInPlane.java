package com.zeetcode.priorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosePointsInPlane {
	
	public class PointComparator implements Comparator<Point> {
		private Point point;
		public PointComparator(Point p) {
			point = p;
		}
		
		public int compare(Point o1, Point o2) {
			double d1 = o1.getDistanceToPoint(point);
			double d2 = o2.getDistanceToPoint(point);
			
			if (d1>d2) {
				return -1;
			} else if (d1 < d2) {
				return 1;
			}
			
			return 0;
		}
		
	}
	
	public List<Point> getKClosePoints(int k, List<Point> points, Point point) {
		if (k == 0) return Collections.emptyList();
		if (points.size() <= k)	return points;
		
		PriorityQueue<Point> q = new PriorityQueue<Point>(k, new PointComparator(point));
		
		for (Point p : points) {
			if (q.size() != k) {
				q.add(p);
			} else {
				Point head = q.peek();
				if (p.getDistanceToPoint(point) < head.getDistanceToPoint(point)) {
					q.poll();
					q.add(p);
				}
					
			}
		}
		
		List<Point> result = new ArrayList<Point>();
		result.addAll(q);
		return result;
	}
	
	public List<Point> getKClosePointsSort(int k, List<Point> points, Point point) {
		if (k == 0) return Collections.emptyList();
		if (points.size() <= k)	return points;
		
		Collections.sort(points, new PointComparator(point));
		
		return points.subList(0, k);
	}

}

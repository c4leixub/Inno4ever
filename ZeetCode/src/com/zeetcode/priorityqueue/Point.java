package com.zeetcode.priorityqueue;

public class Point {
	
	public double x;
	public double y;
	
	public Point() {	x = 0.0;		y = 0.0;	}
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getDistanceToOrigin() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	public double getDistanceToPoint(Point p) {
		return Math.sqrt(Math.pow(p.x-x, 2) + Math.pow(p.y-y, 2));
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}

package com.tony.pattern.bridge;

public abstract class Shape {

	protected Color color;
	
	public Shape(String color) {
		if (color.equals("red")) {
			this.color = new Red();
		} else if (color.equals("green")) {
			this.color = new Green();
		}
	}
	
	public abstract void applyColor();
}

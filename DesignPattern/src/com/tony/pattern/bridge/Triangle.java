package com.tony.pattern.bridge;

public class Triangle extends Shape {

	public Triangle(String color) {
		super(color);
	}
	
	public void applyColor() {
		System.out.println("triangle is apply color");
		this.color.applyColor();
	}

}

package com.tony.pattern.bridge;

public class Square extends Shape {

	public Square(String color) {
		super(color);
	}

	@Override
	public void applyColor() {
		System.out.println("square is applyColor");
		this.color.applyColor();
	}

}

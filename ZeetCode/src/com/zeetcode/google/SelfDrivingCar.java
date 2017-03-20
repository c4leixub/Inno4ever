package com.zeetcode.google;

public class SelfDrivingCar {
	
	public int speed = 1;
	public int pos = 0;
	public int direction = 1;
	
	public void move() {
		pos += (speed * direction);
	}
	
	public void Accelerate() {
		speed *= 2;
	}
	
	public void reverse() {
		direction *= -1;
		speed = 1;
	}
	
	
}

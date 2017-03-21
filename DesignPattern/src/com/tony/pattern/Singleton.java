package com.tony.pattern;

public class Singleton {

	/*
	// Eager initialization
	private static Singleton instance = new Singleton();

	public static Singleton getInstance() {
		return instance;
	}
	*/

	// Lazy initialization plus thread save
	private static Singleton instance;

	// make the constructor private so that this class cannot be
	// instantiated
	private Singleton() {
	}

	public static synchronized Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	public void showMessage() {
		System.out.println("Hello World!");
	}

}

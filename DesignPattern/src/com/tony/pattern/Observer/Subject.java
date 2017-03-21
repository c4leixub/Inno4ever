package com.tony.pattern.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

	private List<Observer> observers;
	private int state;
	private String name;

	public Subject(String name) {
		observers = new ArrayList<Observer>();
		state = 0;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public int getState() {
		return state;
	}
	
	public void attach(Observer o) {
		this.observers.add(o);
	}
	
	public void changeState(int s) {
		state = s;
		notifyAllObserver();
	}
	
	public void notifyAllObserver() {
		for (Observer o : observers) {
			o.update();
		}
	}

}

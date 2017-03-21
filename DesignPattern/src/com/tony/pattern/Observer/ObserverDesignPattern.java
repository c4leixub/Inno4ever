package com.tony.pattern.Observer;

// Observer pattern is used when there is one to many relationship between objects such as if one object is modified, its depenedent objects are to be notified automatically.


public class ObserverDesignPattern {

	public static void main(String[] args) {
		
		Subject s = new Subject("abc");
		
		Observer o1 = new Observer(s, "o1");
		Observer o2 = new Observer(s, "o2");
		
		s.attach(o1);
		s.attach(o2);
		
		s.changeState(1);
	}
}

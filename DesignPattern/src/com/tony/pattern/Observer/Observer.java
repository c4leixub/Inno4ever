package com.tony.pattern.Observer;

public class Observer {
	
	private Subject subject;
	private String name;
	
	public Observer(Subject s, String name) {
		subject = s;
		this.name = name;
	}
	
	public void update() {
		System.out.print("Observer " + name + " get update :");
		System.out.println("Subject " + subject.getName()
								+ " change state to " + subject.getState());
	}

}

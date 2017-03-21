package com.tony.pattern.command;

import java.util.PriorityQueue;
import java.util.Queue;

// act as command invoker
public class Broker {

	private Queue<Order> orders = new PriorityQueue<Order>();
	
	public Broker() {
	}

	public void takeOrder(Order order) {
		orders.add(order);
	}

	// invoke the commands
	public void placeOrders() {
		while(!orders.isEmpty()) {
			orders.poll().execute();
		}
	}

}

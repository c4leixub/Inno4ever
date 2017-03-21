package com.tony.pattern.command;

// act as command
public class Buy implements Order {

	private Stock stock;
	
	public Buy(Stock s) {
		stock = s;
	}
	
	// Command design pattern must have execute method
	@Override
	public void execute() {
		System.out.println("Buy " + stock.getQuantity() + " of " + stock.getName());
	}

}

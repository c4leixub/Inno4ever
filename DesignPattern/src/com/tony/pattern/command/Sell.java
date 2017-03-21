package com.tony.pattern.command;

public class Sell implements Order {

	private Stock stock;
	
	public Sell(Stock s) {
		stock = s;
	}
	
	@Override
	public void execute() {
		System.out.println("Sell " + stock.getQuantity() + " of " + stock.getName());
	}

}

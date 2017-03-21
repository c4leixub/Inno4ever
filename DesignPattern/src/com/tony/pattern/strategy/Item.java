package com.tony.pattern.strategy;

public class Item {

	private String upc;
	private double price;
	
	public Item(String upc, double price) {
		super();
		this.upc = upc;
		this.price = price;
	}
	
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}

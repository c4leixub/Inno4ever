package com.tony.pattern.command;

public class CommandDesignPatternTest {
	public static void main(String[] args) {
		Stock abcStock = new Stock("abc", 10);

		Order buyStockOrder = new Buy(abcStock);
		Order sellStockOrder = new Sell(abcStock);

		Broker broker = new Broker();
		broker.takeOrder(buyStockOrder);
		broker.takeOrder(sellStockOrder);

		broker.placeOrders();
	}
}

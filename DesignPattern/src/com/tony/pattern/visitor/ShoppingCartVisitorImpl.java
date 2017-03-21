package com.tony.pattern.visitor;

public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

	@Override
	public double visit(Book book) {
		double cost = 0;
		// apply 5$ discount if book price is greater than 50
		if (book.getPrice() > 50) {
			cost = book.getPrice() - 5;
		} else {
			cost = book.getPrice();
		}
		System.out.println("Book ISBN::" + book.getIsbn() + " cost = " + cost);
		return cost;
	}

	@Override
	public double visit(Fruit fruit) {
		double cost = fruit.getPricePerKg() * fruit.getWeight();
		System.out.println(fruit.getName() + " cost = " + cost);
		return cost;
	}

}

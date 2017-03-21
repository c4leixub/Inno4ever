package com.tony.pattern.visitor;

public class Book implements Item {

	private double price;
	private String isbn;
	
	public Book(double price, String isbn) {
		super();
		this.price = price;
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public double accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}

}

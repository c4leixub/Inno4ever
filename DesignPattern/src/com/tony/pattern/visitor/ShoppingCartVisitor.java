package com.tony.pattern.visitor;

// A visitor must have visit methods to all the class contains accept method 
public interface ShoppingCartVisitor {

	public double visit(Book b);
	public double visit(Fruit f);
}

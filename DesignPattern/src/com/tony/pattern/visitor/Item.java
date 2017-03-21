package com.tony.pattern.visitor;

// The key of this pattern is the object contains accept method to accept visitor
public interface Item {

	public double accept(ShoppingCartVisitor visitor);
}

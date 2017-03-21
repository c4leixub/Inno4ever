package com.tony.pattern.visitor;

public class Fruit implements Item {

	private int pricePerKg;
    private int weight;
    private String name;
	
	public Fruit(int pricePerKg, int weight, String name) {
		super();
		this.pricePerKg = pricePerKg;
		this.weight = weight;
		this.name = name;
	}
	
	public int getPricePerKg() {
		return pricePerKg;
	}

	public void setPricePerKg(int pricePerKg) {
		this.pricePerKg = pricePerKg;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}

}

package com.tony.pattern.strategy;

// Strategy pattern is used when we have multiple algorithm for a specific task and client decides the actual implementation to be used at runtime.

//Strategy pattern is also known as Policy Pattern. We defines multiple algorithms and let client application pass the algorithm to be used as a parameter. One of the best example of this pattern is Collections.sort() method that takes Comparator parameter. Based on the different implementations of Comparator interfaces, the Objects are getting sorted in different ways,

public class ShoppingCartTest {	
	
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		Item item1 = new Item("1234",10);
		Item item2 = new Item("5678",40);
		cart.addItem(item1);
		cart.addItem(item2);
		
		//pay by paypal
		cart.pay(new PaypalStrategy("myemail@example.com", "mypwd"));
		
		//pay by credit card
		cart.pay(new CreditCardStrategy("Pankaj Kumar", "1234567890123456", "786", "12/15"));
		
	}
}

//Strategy pattern is useful when we have multiple algorithms for specific task and we want our application to be flexible to chose any of the algorithm at runtime for specific task.

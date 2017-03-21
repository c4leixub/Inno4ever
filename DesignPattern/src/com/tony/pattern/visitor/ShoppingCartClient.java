package com.tony.pattern.visitor;

//Visitor Pattern is one of the behavioral design pattern. Visitor pattern is used when we have to perform an operation on a group of similar kind of Objects. With the help of visitor pattern, we can move the operational logic from the objects to another class.
//For example, think of a Shopping cart where we can add different type of items (Elements), when we click on checkout button, it calculates the total amount to be paid. Now we can have the calculation logic in item classes or we can move out this logic to another class using visitor pattern.

public class ShoppingCartClient {

	public static void main(String[] args) {
        Item[] items = new Item[] {
        		new Book(20, "1234"),
        		new Book(100, "5678"),
                new Fruit(10, 2, "Banana"), 
                new Fruit(5, 5, "Apple")
        		};
         
        double total = calculatePrice(items);
        System.out.println("Total Cost = "+total);
    }
 
    private static double calculatePrice(Item[] items) {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        double sum=0;
        for(Item item : items){
            sum = sum + item.accept(visitor);
        }
        return sum;
    }

}

//The benefit of this pattern is that if the logic of operation changes, then we need to make change only in the visitor implementation rather than doing it in all the item classes.

//Another benefit is that adding a new item to the system is easy, it will require change only in visitor interface and implementation and existing item classes will not be affected.

//The drawback of visitor pattern is that we should know the return type of visit() methods at the time of designing otherwise we will have to change the interface and all of its implementations. Another drawback is that if there are too many implementations of visitor interface, it makes it hard to extend.

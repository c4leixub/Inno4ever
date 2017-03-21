package com.tony.pattern.bridge;

//When we have interface hierarchies in both interfaces as well as implementations, then builder design pattern is used to decouple the interfaces from implementation and hiding the implementation details from the client programs.

//The immplementation of bridge design pattern follows the notion to prefer Composition over inheritance.
public class BridgePatternTest {
	 
    public static void main(String[] args) {
        Shape tri = new Triangle("red");
        tri.applyColor();
         
        Shape sq = new Square("green");
        sq.applyColor();
    }
 
}

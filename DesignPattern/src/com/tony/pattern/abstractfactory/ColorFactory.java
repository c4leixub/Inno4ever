package com.tony.pattern.abstractfactory;

public class ColorFactory extends AbstractFactory {

	@Override
	public Color getColor(String color) {
		if(color == null){
	         return null;
	      }		
	      if(color.equalsIgnoreCase("RED")){
	         return new Red();
	      } else if(color.equalsIgnoreCase("GREEN")){
	         return new Green();
	      } else if(color.equalsIgnoreCase("BLUE")){
	         return new Blue();
	      }
	      return null;
	}

	@Override
	public Shape getShape(String shape) {
		return null;
	}
	
	public class Red implements Color {

		@Override
		public void fill() {
			System.out.println("Inside Red::fill() method.");
		}
	}

	public class Green implements Color {

		@Override
		public void fill() {
			System.out.println("Inside Green::fill() method.");
		}
	}

	public class Blue implements Color {

		@Override
		public void fill() {
			System.out.println("Inside Blue::fill() method.");
		}
	}
}

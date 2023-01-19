package com.lec.ex04_chape;

public class TestMain {
	public static void main(String[] args) {
		Shape[] shape = {new Circle(5),
						new Triangle(5, 10),
						new Rectangle(5, 10)}; // array
		
		for (Shape s : shape) {
			s.draw();
			System.out.println("넓이는 " + s.area());
		}
	
	}

}

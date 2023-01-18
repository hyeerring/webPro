package com.lec.ex04_product;

public class ProductMain {
	public static void main(String[] args) {
		System.out.println(Product.count);
		// (==)
//		Product.staticMethod();
		
		Product p1 = new Product();
		p1.infoPrint();
		Product p2 = new Product();
		p2.infoPrint();
		System.out.println("static 변수: " + Product.count);
		System.out.println("static 변수: " + p1.count);
		System.out.println("static 변수: " + p2.count);
	}
}

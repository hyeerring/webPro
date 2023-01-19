package com.lec.ex04_chape;

import com.lec.cons.Constant;

public class Circle extends Shape {

	private int r;

	public Circle() {
	}

	public Circle(int r) {
		super();
		this.r = r;
	}

	@Override
	public double area() {
		return Constant.PI * r * r;
	}

	@Override
	public void draw() {
		System.out.print("원형의");
		super.draw();
	}

}

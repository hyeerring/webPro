package com.lec.ex04_chape;

public class Rectangle extends Shape {

	private int w; // 가로
	private int h; // 높이

	public Rectangle() {
		// TODO Auto-generated constructor stub
	}

	public Rectangle(int w, int h) {
		super();
		this.w = w;
		this.h = h;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return w * h;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.print("사각형");
		super.draw();
	}
}

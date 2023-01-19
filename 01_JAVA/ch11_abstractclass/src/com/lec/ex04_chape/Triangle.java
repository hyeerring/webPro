package com.lec.ex04_chape;

public class Triangle extends Shape {
	private int w; // 가로
	private int h; // 높이

	public Triangle() {
		// TODO Auto-generated constructor stub
	}

	public Triangle(int w, int h) {
		super();
		this.w = w;
		this.h = h;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return h * w * 0.5;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.print("삼각형");
		super.draw();
	}
}

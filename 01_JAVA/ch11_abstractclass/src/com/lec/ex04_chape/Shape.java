package com.lec.ex04_chape;

public abstract class Shape {
public void draw() {
	System.out.println("도형을 그려요!");
}
	public abstract double area(); // abstract 추상메소드
}

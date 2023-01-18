package com.lec.ex03_point.copy;

// 2차원
public class Point {
	private int x;
	private int y;

	public Point() {
		System.out.println("Point(부모클래스 = Parent클래스 = Super클래스 = 상위클래스) 생성자");
	}

	// 매개변수 없는 생성자 항수는 없음
	public Point(int x, int y) {
		System.out.println("매개변수 있는 Point 생성자");
		this.x = x;
		this.y = y;
	}

	public void InfoPrint() {
		System.out.print("좌표 : x = " + getX() + "\ty = " + getY());
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}

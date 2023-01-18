package com.lec.ex02_protected.copy;

// private i, j 
// public set I(), get I(), set J(), get J()
public class Child extends SuperIJ {
	private int total;

	public Child() {
		System.out.println("매개변수 없는 Child 생성자 함수");
	}

	public Child(int i, int j) {
		super(i, j);
		System.out.println("매개변수 있는 Child 생성자 함수로 i, j값 초기화");
	}

	public void sum() {
		total = getI() + getJ();
		System.out.println("i = " + getI() + "\tj = " + getJ() + "\ttotal = " + total);
	}

}

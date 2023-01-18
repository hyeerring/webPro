package com.lec.ex02_protected.copy;

public class SuperIJ {
	// private 대신 protected로 사용할 경우 상속받은 패키지에서 자유롭게 사용 가능
	// this.i = i; 가능
	private int i;
	private int j;

	public SuperIJ() { // 상속받은 클래스에서 부모클래스의 디폴트 생성자가 호출(기본적으로)
		super();
		System.out.println("매개변수 없는 SuperIJ 생성자 함수");
	}

	//
	public SuperIJ(int i, int j) {
		super();
		System.out.println("매개변수 있는 SuperIJ 생성자 함수로 i, j값 초기화");
		this.i = i;
		this.j = j;
	}

	//
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

}

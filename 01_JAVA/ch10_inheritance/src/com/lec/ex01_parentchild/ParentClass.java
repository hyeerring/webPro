package com.lec.ex01_parentchild;

public class ParentClass {
	String pStr = "부모클래스";

	public ParentClass() {
		System.out.println("부모클래스(=Parent 클래스 = Super 클래스) 생성자 함수");
	}

	public void getPapaName() {
		System.out.println("아빠이름: 김철수");
	}

	public void getMamiName() {
		System.out.println("엄마이름: 김순이");
	}
}

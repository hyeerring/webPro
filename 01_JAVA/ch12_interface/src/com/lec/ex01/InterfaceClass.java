package com.lec.ex01;

// CONSTANT_NUM, CONSTANT_NUM, method1, method2
public class InterfaceClass implements InterfaceEx01, InterfaceEx02 {

	@Override
	public String method2() {
		// TODO Auto-generated method stub
		System.out.println("실제 구현은 implements한 클래스에서 한다: method2");
		return null;
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("실제 구현은 implements한 클래스에서 한다: method1");

	}

}

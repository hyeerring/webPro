package com.lec.ex02;

public class TestMain {
	public static void main(String[] args) {
		
	SuperClass obj = new ChildClass(); // SuperClass는 타입으로만 가능, 객체 생성은 불가능
	obj.method1();
	obj.method2();
	obj.method3();
	}
}

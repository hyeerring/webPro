package com.lec.ex06_override;

// mathod1(), mathod2()
public class Child extends Parent {
	public Child() {
		System.out.println("매개변수 없는 Child 생성자");
	}

	public Child(int i) {
		System.out.println("매개변수 있는 Child 생성자");
	}

	@Override
	public void method1() { // override = 함수의 재정의
		System.out.println("Child의 method1()");
	}

//	public void method2() {
//		System.out.println("Child의 method2()");
//	}
	public void method3() {
		System.out.println("Child의 method3()");
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}

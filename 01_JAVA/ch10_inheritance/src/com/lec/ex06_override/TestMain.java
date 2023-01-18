package com.lec.ex06_override;

public class TestMain {

	public static void main(String[] args) {
		Parent pObj1 = new Parent();
		Parent pObj2 = new Parent(10);
		System.out.println("pObj1과 pObj2는 같은가? " + pObj1.equals(pObj2)); // Object의 equals
		pObj1.method1();
//		pObj2.method1();
		pObj1.mathod2();

		System.out.println("------------------------------");

		Child cObj1 = new Child(); // Parent() -> Child();
		Child cObj2 = new Child(2); // Parent() -> Child(2);
		cObj1.method1();
		cObj2.mathod2();
		cObj1.method3();

		System.out.println("cObj1과 cObj는 같은가?" + cObj1.equals(cObj2)); // Child의 equals

		System.out.println("------------------------------");
		Parent Obj = new Child();
		Obj.method1();
		Obj.mathod2();
		System.out.println();
//		Obj.mathod3(); Obj 변수의 타입 때문에 불가
		((Child) Obj).method3(); // 객체의 명시적인 형변환 !위험!

		if (Obj instanceof Child) { // 객체의 명시적인 형변환의 경우 instanceof
			((Child) Obj).method3();
			System.out.println("형변환 불가");
		}
	}

}

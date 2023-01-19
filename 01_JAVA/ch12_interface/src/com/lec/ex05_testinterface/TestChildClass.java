package com.lec.ex05_testinterface;

// i1, i2, i3, i10, m1(), m2(), m3(), m10()
public class TestChildClass extends TestClass implements I10 {

	@Override
	public void m10() {
		System.out.println("상수 i10 :" + i10);
	}

}

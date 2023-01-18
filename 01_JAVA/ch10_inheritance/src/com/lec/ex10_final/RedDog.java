package com.lec.ex10_final;

//speed, running(Dog에서 override), stop(Animal의 final 메소드 stop)
public class RedDog extends Dog {
	public void method() {
		System.out.println("++ 속도는 " + speed);
	}
}
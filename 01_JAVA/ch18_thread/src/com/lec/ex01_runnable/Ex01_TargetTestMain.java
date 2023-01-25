package com.lec.ex01_runnable;

public class Ex01_TargetTestMain {
	public static void main(String[] args) {
		Target target = new Target();
		
		// "A"라는 이름의 쓰레드를 생성
		// target.run()을 동시에 수행할 쓰레드
		Thread t1 = new Thread(target, "* A");
		
		// "B"라는 이름의 쓰레드를 생성
		// target.run()을 동시에 수행할 쓰레드
		Thread t2 = new Thread(target, "~ B");
	
		t1.start();
		t2.start();
		System.out.println("main 함수 스레드 이름: " + Thread.currentThread().getName());
		System.out.println("main 함수 끝");
	}
}

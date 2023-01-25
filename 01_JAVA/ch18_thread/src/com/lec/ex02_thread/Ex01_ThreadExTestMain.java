package com.lec.ex02_thread;

public class Ex01_ThreadExTestMain {
	public static void main(String[] args) {
		
		Thread t1 = new ThreadEx01();
		t1.setName("* A");

		Thread t2 = new ThreadEx01("- B");
		
		t1.start();
		t2.start();
		
		System.out.println("main함수 스레드명: " + Thread.currentThread().getName());
		System.out.println("main함수 끝");
	}
}

package com.lec.ex04_targetNthreadN.copy;

// Target 객체는 1개, 스레드는 N개
// 스레드 하나가 Target 객체를 공유
public class TargetExTestMain {
	public static void main(String[] args) {
		// run() 함수에 A면 num증가, 아니면 num = 0
		Runnable targetA = new TargetEx();
		Runnable targetB = new TargetEx();
		Thread threadA = new Thread(targetA, "A");
		Thread threadB = new Thread(targetB, "B");
		
		threadA.start();
		threadB.start();
		
		System.out.println("main 함수 끝");
		
	}
}

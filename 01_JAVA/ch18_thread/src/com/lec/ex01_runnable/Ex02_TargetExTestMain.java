package com.lec.ex01_runnable;

public class Ex02_TargetExTestMain {
	public static void main(String[] args) {
		Runnable target01 = new TargetEx01(); // 안녕하세요 10번
		Runnable target02 = new TargetEx02(); // 반갑습니다 10번
		
		// "A"라는 이름의 쓰레드 생성
		Thread threadA = new Thread(target01);
		threadA.setName("A");
		
		// 쓰레드 생성 : 이름을 입력하지 않을 경우 자동 생성
		Thread threadB = new Thread(target02);
		
		threadA.start();
		threadB.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("main 함수 이름: " + Thread.currentThread().getName() + "의" + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
//				e.printStackTrace();
			}
		}
	}
}

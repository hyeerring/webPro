package com.lex.ex07_timer;

import java.util.Timer;

public class TimerTestMain {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("시작");
		Timer timer = new Timer(true); // 프로그램 종료시 timer가 메모리에 상주하지 않음
		TimerTaskEx01 task1 = new TimerTaskEx01();
		TimerTaskEx02 task2 = new TimerTaskEx02();
		// 2초후에 task1.run() 수행
		timer.schedule(task1, 2000);
		// 1초 후부터 0.5초마다 task2.run() 수행
		timer.schedule(task2, 1000, 500);
		
		Thread.sleep(10000);
		
		System.out.println("끝");
	}

}

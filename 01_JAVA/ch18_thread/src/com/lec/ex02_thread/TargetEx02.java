package com.lec.ex02_thread;

// 반갑습니다 10번 반복
public class TargetEx02 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "반갑습니다 - " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
//				e.printStackTrace();
			}
		}
	}
}

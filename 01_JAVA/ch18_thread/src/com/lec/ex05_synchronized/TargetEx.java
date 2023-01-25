package com.lec.ex05_synchronized;

public class TargetEx implements Runnable {

	private int num = 0;

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			out();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private synchronized void out() {
		if (Thread.currentThread().getName().equals("A")) {
			System.out.println("~~ A 스레드 수행 중 num 증가");
			num++;
		}
		System.out.println(Thread.currentThread().getName() + "의 num = " + num);

	}

}

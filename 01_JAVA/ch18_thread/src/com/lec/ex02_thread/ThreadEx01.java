package com.lec.ex02_thread;

public class ThreadEx01 extends Thread {

	public ThreadEx01() {
		// TODO Auto-generated constructor stub
		super();
	}

	public ThreadEx01(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "스레드의 i" + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	} // run
}

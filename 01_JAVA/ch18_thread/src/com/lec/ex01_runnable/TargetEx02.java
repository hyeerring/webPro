package com.lec.ex01_runnable;

public class TargetEx02 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++) {
			System.out.println("~ 반갑습니다. " + i + Thread.currentThread().getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
//				e.printStackTrace();
			}
		}
	}
	

}

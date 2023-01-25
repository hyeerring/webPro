package com.lec.ex05_atm;

public class AtmTarget implements Runnable {
	private ATM atm;
	private boolean flag;

	public AtmTarget(ATM atm) {
		this.atm = atm;
	}

	@Override
	public void run() {
		// 토글 방식으로 입금, 출금
		for (int i = 0; i < 10; i++) {
			if (flag) {
				atm.withdraw(1000, Thread.currentThread().getName());
			} else {
				atm.deposit(1000, Thread.currentThread().getName());
				flag = true;
			}
		}
	}

}

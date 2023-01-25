package com.lec.ex05_atm;

public class AtmMain {

	public static void main(String[] args) {
		ATM atm = new ATM(1000);
		Runnable card = new AtmTarget(atm);
		Thread t1 = new Thread(card, "- 엄마");
		Thread t2 = new Thread(card, "- 아빠");
		t1.start();
		t2.start();
		
	}

}

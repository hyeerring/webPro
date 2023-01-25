package com.lec.ex05_atm;

public class ATM {
	private int balance;

	public ATM(int balance) {
		super();
		this.balance = balance;
	}

	public synchronized void deposit(int amount, String who) {
		System.out.println(who + "가 입금 시작");
		balance += amount;
		System.out.println(who + "가" + amount + "원 입금하였습니다. 잔액: " + balance);
		System.out.println("+ 입금종료");
	}

	public synchronized void withdraw(int amount, String who) {
		System.out.println(who + "가 출금 시작");
		balance -= amount;
		System.out.println(who + "가" + amount + "원 출금하였습니다. 잔액: " + balance);
		System.out.println("+ 출금종료");
	}

	public int getBalance() {
		return balance;
	}

}

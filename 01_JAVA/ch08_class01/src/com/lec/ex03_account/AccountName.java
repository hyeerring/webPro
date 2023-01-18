package com.lec.ex03_account;

public class AccountName {
	public static void main(String[] args) {
		Account hong = new Account("110-12345-67890", "홍길동", 10000);
		hong.infoPrint();
		System.out.println(hong.infoString());
		Account hong1 = new Account("110-12345-67890", "홍길순");
		System.out.println(hong1.infoString());
		Account hong2 = new Account();
		System.out.println(hong2.infoString());
		hong.withdraw(500);
		hong.withdraw(5000);
		hong.deposit(2200000000L);
		hong.withdraw(2300000000L);
	}
}

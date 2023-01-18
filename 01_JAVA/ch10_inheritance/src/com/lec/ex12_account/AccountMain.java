package com.lec.ex12_account;

public class AccountMain {
	public static void main(String[] args) {
		Account acc1 = new Account("1111-1111", "김지우");
		CheckingAccount acc2 = new CheckingAccount("2222-2222", "김웅이", 2000, "1111-2222-1111-2222");
		CreaditLineAccount acc3 = new CreaditLineAccount("3333-3333", "김이슬", 3000, "3333-4444-3333-4444", 10000);
		
		acc1.deposit(4000);
		acc1.withdraw(2000);
		
		acc2.pay("1111-2222-1111-2222", 2000);
		acc2.pay("1111-2222-1111-2222", 2000);
		acc2.pay("1111-2222-1111-3333", 2000);
		
	}
}

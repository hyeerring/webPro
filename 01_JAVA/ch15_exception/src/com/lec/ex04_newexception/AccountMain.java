package com.lec.ex04_newexception;

public class AccountMain {
	public static void main(String[] args) {
		Account acc1 = new Account("1111-1111", "김길동");
		
		acc1.deposit(4000);
		try {
			acc1.withdraw(6000);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		
	}
}

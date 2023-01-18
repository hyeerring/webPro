package com.lec.ex03_account;

/*  데이터(속성): accountNo(String), ownerName(String), balance(long)
 *  기능(메소드): deposit(예금), withdraw(인출), infoPrint(정보출력)
 */
public class Account {
	private String accountNo;
	private String ownerName;
	private long balance;

	public Account() { // acc 생성자
	}

	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		// balance = 0;
		System.out.println(ownerName + "님 계좌 개설 감사합니다. 잔액: " + balance);
	}

	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.println(ownerName + "님 계좌 개설 감사합니다. 잔액: " + balance);
	}

	public void deposit(long money) { // 예금하기
		balance += money;
		System.out.println(money + "원 입금하여 잔액: " + balance + "입니다.");
	}

	public void withdraw(long money) { // 잔액이 있을 경우만 인출. 잔액 부족 시 경고 출력
		if (balance >= money) {
			balance -= money;
			System.out.println(money + "원 인출하여 잔액: " + balance + "입니다.");
		} else { // 강제 예외 발생
			System.out.println("잔액이 부족합니다.");
		}
	}

	public void infoPrint() { // "110-12345-67890" 홍길동님 잔액: 00원
//		System.out.println("\"110-12345-67890\"" + ownerName + "님 잔액: " + balance + "원");
		System.out.printf(" \" %s \"%s님 잔액: %d원\n ", accountNo, ownerName, balance);
	}

	public String infoString() {
//		return "\"110-12345-67890\"" + ownerName + "님 잔액: " + balance + "원";
		return String.format(" \" %s \"%s님 잔액: %d원\n ", accountNo, ownerName, balance);
	}

	// getter: accountNo, ownerName, balance
	// setter: ownerName

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
	
}

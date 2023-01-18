package com.lec.ex12_account;

public class CreaditLineAccount extends CheckingAccount {
	private long creaditLine;

	public CreaditLineAccount(String accountNo, String ownerName, String cardNo, long creaditLine) {
		super(accountNo, ownerName, cardNo);
		creaditLine = creaditLine;
	}

	public CreaditLineAccount(String accountNo, String ownerName, long balance, String cardNo, long creaditLine) {
		super(accountNo, ownerName, balance, cardNo);
		creaditLine = creaditLine;
	}

	@Override
	public void pay(String cardNo, int amount) {
		if (getCardNo().equals(cardNo)) { // 올바른 카드번호 입력
			if (creaditLine >= amount) { // 지불 가능
				creaditLine -= amount;
				System.out.printf("%s님 %d원 지불되었습니다.", getOwnerName(), amount);
			} else { // 잔액부족으로 지불 불가
				System.out.printf("%s님 잔액이 부족하여 지불이 불가합니다.\n", getOwnerName());
			}

		} else { // 잘못된 카드번호 입력
			System.out.println("유효한 카드 번호가 아닙니다.");
		}
	}
}

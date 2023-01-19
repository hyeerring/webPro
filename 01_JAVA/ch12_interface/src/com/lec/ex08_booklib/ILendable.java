package com.lec.ex08_booklib;

public interface ILendable {
	public byte STATE_BORROWED = 1; // 대출 중
	public byte STATE_NORMAL = 0; // 대출 가능
	void checkOut(String borrower, String checkOutDate); //대출
	void checkIn(); // 반납
	void printState(); // "책번호 책이름 저자 대출가능 여부" 출력
}

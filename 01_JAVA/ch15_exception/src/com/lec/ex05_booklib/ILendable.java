package com.lec.ex05_booklib;

public interface ILendable {
	public byte STATE_BORROWED = 1; // 대출 중
	public byte STATE_NORMAL = 0; // 대출 가능

	void checkOut(String borrower); // 대출

	void checkIn() throws Exception; // 반납
}

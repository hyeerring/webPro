package com.lec.quiz;

public class BookLib extends BookInfo implements ILendable {

	private String borrower; // 대출인
	private String checkOutDate; // 대출일자
	private byte state; // 대출가능(0), 대출중(1)

	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		// 대출
		if (state == STATE_BORROWED) { // 대출 중이면 메세지 보내고 끝
			System.out.println(getBookTitle() + " 도서는 대출 중 입니다.");
			return;
		}
		// state가 0(STATE_NORMAL)이라 대출 진행
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; // 대출 중으로 변환
		System.out.println(getBookTitle() + " 도서가 대출 처리 되었습니다.");
		System.out.println("대출인 : " + borrower + "\t대출일 : " + checkOutDate);
	}

	@Override
	public void checkIn() {
		// 반납
		if (state == STATE_NORMAL) {
			System.out.println(getBookTitle() + " 도서는 반납 완료된 책입니다. 확인이 필요합니다.");
			return;
		}
		// state가 1(STATE_BORROWED)이라 반납 처리
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle() + " 도서가 반납 완료되었습니다.");
	}

	@Override
	public void printState() {
		// 도서 목록 출력
		String msg = getBookNo() + "\t" + getBookTitle() + "( " + getWriter() + " 지음) ㅣ ";
		msg += state == STATE_NORMAL ? "대출가능" : "대출 중";
		System.out.println(msg);
	}

	public String getBorrower() {
		return borrower;
	}

	public String getCheckoutDate() {
		return checkOutDate;
	}

	public byte getState() {
		return state;
	}

}

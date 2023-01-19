package com.lec.ex08_booklib;

// Book book = new book("890ㅁ-01-01", "java", "김철수")
public class Book implements ILendable {
	private String bookNo; // 책번호
	private String bookTitle; // 책이름
	private String writer; // 저자
	private String borrower; // 대출인
	private String checkOutDate; // 대출일
	private byte state; // 대출가능(0), 대출중(1)

	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		// 대출
		if (state == STATE_BORROWED) { // 대출 중이면 메세지 보내고 끝
			System.out.println(bookTitle + " 도서는 대출 중 입니다.");
			return;
		}
		// state가 0(STATE_NORMAL)이라 대출 진행
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; // 대출 중으로 변환
		System.out.println(bookTitle + " 도서가 대출 처리 되었습니다.");
		System.out.println("대출인 : " + borrower + "\t대출일 : " + checkOutDate);
	}

	@Override
	public void checkIn() {
		// 반납
		if (state == STATE_NORMAL) {
			System.out.println(bookTitle + " 도서는 반납 완료된 책입니다. 확인이 필요합니다.");
			return;
		}
		// state가 1(STATE_BORROWED)이라 반납 처리
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + " 도서가 반납 완료되었습니다.");
	}

	@Override
	public void printState() {
		// 도서 목록 출력
//		if(state==STATE_NORMAL) {
//			System.out.println(bookNo + "\t" + bookTitle + "(" + writer +"著) - 대출가능");
//		}else if(state ==STATE_BORROWED) {
//			System.out.println(bookNo + "\t" + bookTitle + "(" + writer +"著) - 대출 중");
//		}
		String msg = bookNo + "\t" + bookTitle + "( " + writer + " 지음) ㅣ ";
		msg += state == STATE_NORMAL ? "대출가능" : "대출 중";
		System.out.println(msg);
	}

	// getters
	public String getBookNo() {
		return bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public String getBorrower() {
		return borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public byte getState() {
		return state;
	}

}

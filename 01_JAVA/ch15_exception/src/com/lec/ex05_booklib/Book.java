package com.lec.ex05_booklib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Book book = new book("890ㅁ-01-01", "java", "김철수")
public class Book implements ILendable {
	private String bookNo; // 책번호
	private String bookTitle; // 책이름
	private String writer; // 저자
	private String borrower; // 대출인
	private Date checkOutDate; // 대출일
	private byte state; // 대출가능(0), 대출중(1)

	public Book(String bookNo, String bookTitle, String writer) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	@Override
	public void checkOut(String borrower) {
		// 대출
		// 검색한 도서가 대출 중의 경우 메세지 뿌리고 끝
		if (state == STATE_BORROWED) {
			System.out.println("검색하신 " + bookTitle + " 도서는 대출 중 입니다.");
			return;
		}
		// 검색한 도서가 STATE_NORMAL 이라 대출 진행
		this.borrower = borrower;
		checkOutDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		state = STATE_BORROWED;
		System.out.println(bookTitle + "도서가 대출 처리되었습니다.");
		System.out.println("대출인: " + borrower + "\t대출일: " + sdf.format(checkOutDate));
	}

	@Override
	public void checkIn() throws Exception {
		// 반납
		if (state == STATE_NORMAL) {
			System.out.println("== 해당 도서는 반납 완료된 책입니다. 확인이 필요합니다. ==");
		}
		// 대출일과 현재 시점간의 날짜 계산
		Date now = new Date();
		long term = now.getTime() - checkOutDate.getTime();
		long day = term / (1000 * 60 * 60 * 24);
		// 연체의 경우 연체료 출력 + 연체료 납부 확인 후 반납 완료
		if (day > 14) {
			System.out.println(borrower + "님" + (day - 14) + "일 연체되었습니다.");
			System.out.println("연체료 " + ((day - 14) * 500) + "원 입니다.");
			Scanner scanner = new Scanner(System.in);
			System.out.println("연체료 납입 후 확인(y)을 눌러주세요.");
			if (!scanner.next().trim().equalsIgnoreCase("y")) {
				System.out.println("연체료 납입이 필요합니다.");
				return;
			} // if: 연체료
		} // if: 연체
			// 해당 도서가 STATE_BORROWED 이라 반납 가능
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("반납이 완료되었습니다. 감사합니다.");
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String msg = "[책번호]" + bookNo + "\t[책 제목]" + bookTitle + "\t[저자]" + writer + "\t";
		msg += state == STATE_NORMAL ? "대출 가능" : "대출 중\t" + sdf.format(checkOutDate);
		return msg;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public byte getState() {
		return state;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

}

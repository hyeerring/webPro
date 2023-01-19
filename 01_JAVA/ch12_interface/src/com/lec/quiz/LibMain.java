package com.lec.quiz;

import java.util.Scanner;

public class LibMain {
	public static void main(String[] args) {
		BookLib[] BookLibs = { new BookLib("810마-01-10", "java", "김길동"), new BookLib("820마-02-20", "oracle", "이길동"),
				new BookLib("830마-03-30", "mysql", "삼길동"), new BookLib("840마-04-40", "jdbc", "사길동"),
				new BookLib("850마-05-50", "html", "오길동") };
		Scanner scanner = new Scanner(System.in);
		int fn; // 기능번호 (1: 대출 / 2:반납 / 3: 책 List / 0: 종료)
		int idx; // 대출하거나 반납할 때 조회된 책의 index
		String bTittle, borrower, checkOutDate; // 사용자에게 받을 책이름, 대출인, 대출일

		do {
			System.out.println("1: 대출 / 2:반납 / 3: 책 List / 0: 종료");
			fn = scanner.nextInt();
			switch (fn) {
			case 1:
				// 대출 : 1.책이름입력 2.책조회 3.대출 가능여부 확인 4.대출인입력 5.대출일입력 6.대출메소드 호출
				/* 1. 책이름 입력 */
				System.out.print("대출하는 책 이름을 입력하세요: ");
				bTittle = scanner.next(); // white-space 앞까지의 스트링만 받음
				/* 2. 책 조회 */
				for (idx = 0; idx < BookLibs.length; idx++) {
					if (bTittle.equals(BookLibs[idx].getBookTitle())) {
						break;
					}
				}
				if (idx == BookLibs.length) {
					System.out.println("도서관에서 보유하지 않은 도서입니다.");
				} else { // BookLib[idx] 도서를 대출
					/* 3. 대출 가능여부 확인 */
					if (BookLibs[idx].getState() == BookLib.STATE_BORROWED) {
						System.out.println("현재 대출 중인 도서입니다.");
					} else {
						/* 4. 대출인 입력 */
						System.out.println("대출인을 입력하세요: ");
						borrower = scanner.next();
						/* 5.대출일 입력 */
						System.out.println("오늘 날짜를 입력하세요: ");
						checkOutDate = scanner.next(); // 2022-12-01(O), 2002 12 01(X)
						/* 6. 대출메소드 호출 */
						BookLibs[idx].checkOut(borrower, checkOutDate);
					}

				}
				break;
			case 2:
				// 반납 : 1.책이름입력 2.반납여부 확인 3.반납메소드 호출
				/* 1. 책이름 입력 */
				System.out.print("반납하는 책 이름을 입력하세요: ");
				bTittle = scanner.next(); // white-space 앞까지의 스트링만 받음
				/* 2. 책 조회 */
				for (idx = 0; idx < BookLibs.length; idx++) {
					if (bTittle.equals(BookLibs[idx].getBookTitle())) {
						break;
					}
				}
				if (idx == BookLibs.length) {
					System.out.println("해당 도서는 본 도서관의 책이 아닙니다.");
				} else {
					/* 3. 반납메소드 호출 */
					BookLibs[idx].checkIn();
				}
				break;
			case 3:
				// 책 List 출력: for문을 이용하여 출력
				for (BookLib BookLib : BookLibs) {
					BookLib.printState();
				}
			}
		} while (fn != 0);
		System.out.println("종료합니다. 방문해 주셔서 감사합니다.");
	} // main

} // class

package com.lex.ex01_string;

import java.util.Iterator;
// 전화번호 뒷자리를 입력받아 검색된 전화번호(중복된 뒷자리 가능)을 출력
import java.util.Scanner;

public class Ex07_searchPostTel {
	public static void main(String[] args) {
		String[] tels = { "010-6666-8888", "010-7777-8888", "010-8888-8888", "010-9999-9999" };
		Scanner sc = new Scanner(System.in);

		while (true) {
			boolean searchOk = false; // 검색한 결과가 있으면 true
			System.out.print("검색하고자 회원의 전화번호 뒷자리를 입력하세요(종료: X) :");
			String searchTel = sc.next();
			if (searchTel.equalsIgnoreCase("x"))
				break;
			for (int i = 0; i < tels.length; i++) {
				// int idx = tels[i].lastIndexOf("-"); //8,6,......
				// String postTel = tels[i].substring(idx+1);
				// System.out.println(i+"번째 뒷자리 : " +postTel);
				String postTel = tels[i].substring(tels[i].lastIndexOf("-") + 1);
				if (postTel.equals(searchTel)) {
					System.out.println("검색하신 전화번호는: " + tels[i]);
					searchOk = true;
				}
			}
			if (!searchOk) {
				System.out.println("검색하신 전화번호는 존재하지 않는 번호입니다.");
			}
		} // while
	} // main

} // class

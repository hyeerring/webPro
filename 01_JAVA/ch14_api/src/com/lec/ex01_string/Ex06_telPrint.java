package com.lex.ex01_string;

import java.util.Scanner;

// 전화번호 입력받아 전화번호, 짝수번째문자, 꺼꾸로, 국번, 뒷자리 출력
public class Ex06_telPrint {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String telNo;
		do {
			System.out.print("전화번호를 입력하세요(종료 x): ");
			telNo = scanner.next(); // "010 2222 3333"
			System.out.println(
					"입력한 전화번호: " + telNo.substring(0, 3) + "-" + telNo.substring(3, 7) + "-" + telNo.substring(7));
			System.out.print("짝수번째 문자열: ");
			for (int i = 0; i < telNo.length(); i += 2) {
				System.out.print(telNo.charAt(i) + "  ");
			}
			System.out.println(); // 개행
			System.out.print("전화번호를 꺼꾸로: ");
			for (int j = telNo.length(); j >= 0; j--) {
				System.out.print(telNo.charAt(j));
			}
			System.out.println(); // 개행

		} while (!telNo.equalsIgnoreCase("x"));

	}// main
}// class

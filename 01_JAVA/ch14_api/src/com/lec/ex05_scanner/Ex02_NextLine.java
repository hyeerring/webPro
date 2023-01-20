package com.lex.ex05_scanner;

import java.util.Scanner;

public class Ex02_NextLine {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("주소를 입력하세요: ");
//		scanner.nextLine(); 버퍼가 깨끗한 경우 버퍼를 지울 필요가 없음
		String address = scanner.nextLine();
		System.out.println("입력한 주소는 " + address + "입니다.");

		System.out.print("나이를 입력하세요: ");
		int age = scanner.nextInt();
		System.out.println("입력한 나이는 " + age + "살 입니다.");

		System.out.print("이름을 입력하세요: ");
		// 현재 버퍼에 \n이 있는 상태
		scanner.nextLine();
		String name = scanner.nextLine();
		System.out.println("입력한 이름은 " + name + "입니다.");

		System.out.println("프로그램 끝");
	}
}

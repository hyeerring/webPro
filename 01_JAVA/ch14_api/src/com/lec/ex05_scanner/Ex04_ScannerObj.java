package com.lex.ex05_scanner;

import java.util.Scanner;

public class Ex04_ScannerObj {
	public static void main(String[] args) {
		Scanner scMain = new Scanner(System.in);
		System.out.print("이름을 입력하세요: ");
		String name = scMain.nextLine();
		System.out.println("입력한 이름은 " + name + "입니다.");
		// 메소드: 별명을 입력받아 출력
		getNicname(scMain);
		System.out.print("나이를 입력하세요: ");
		int age = scMain.nextInt();
		System.out.println("입력한 나이는 " + age + "살 입니다.");

		System.out.print("프로그램 끝");
		scMain.close();
	}

	private static void getNicname(Scanner scNick) {
		System.out.print("사용하실 별명을 입력하세요: ");
		String nickName = scNick.next();
		System.out.println("입력한 별명은 " + nickName + "입니다.");
	}
}

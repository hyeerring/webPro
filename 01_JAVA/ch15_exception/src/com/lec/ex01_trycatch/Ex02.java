package com.lec.ex01_trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i; // 사용자에게 입력받을 수를 저장
		int j = 1;
		System.out.print("첫번째 정수: ");

		do {
			try {
				i = scanner.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("첫번째 수에 문자 또는 실수를 입력했습니다. 다시 입력하세요.");
				scanner.nextLine(); // 버퍼를 지우는 목적
			}
		} while (true);

		System.out.print("두번째 정수: ");

		try {
			j = scanner.nextInt();
			System.out.println("i / j = " + (i / j)); // 예외가 발생할 수 있는 부분
		} catch (InputMismatchException e) {
			System.out.println("** 예외메세지 : " + e.getMessage()); // 예외메세지 출력
			System.out.println("두번째 수에 문자 또는 실수를 입력하여 1로 대체됩니다.");
//			상위 클래스는 가장 마지막에 위치해야 한다
		} catch (Exception e) {
			System.out.println("** 예외메세지 : " + e.getMessage()); // 예외메세지 출력
		}

		System.out.println("i = " + i + "\tj = " + j);
		System.out.println("i * j = " + (i * j));
		System.out.println("i + j = " + (i + j));
		System.out.println("i - j = " + (i - j));
		System.out.println("DONE");
		scanner.close();
	}
}

package com.lec.ex01_trycatch;

// Exception 2개 처리
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j; // 사용자에게 입력받을 수를 저장
		System.out.print("첫번째 정수: ");
		i = scanner.nextInt();
		System.out.print("두번째 정수: ");
		j = scanner.nextInt();
		System.out.println("i = " + i + "\tj = " + j);
		System.out.println("i * j = " + (i * j));

		try {
			System.out.println("i / j = " + (i / j)); // 예외가 발생할 수 있는 부분
		} catch (Exception e) {
			// 예외 발생 시 실행하는 절
			System.out.println("*** 예외메세지: " + e.getMessage() + "***"); // 예외메세지 출력
//			e.printStackTrace(); // 예외메세지 출력보다 자세하게 알려줌
		}

		System.out.println("i + j = " + (i + j));
		System.out.println("i - j = " + (i - j));
		System.out.println("DONE");
		scanner.close();
	}

}

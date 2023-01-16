package com.lec.quiz;

import java.util.Scanner;

//(Quiz 2) 입력한 수가 짝수인지 홀수인지 출력하세요.
public class Quiz02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 입력하세요. : ");
		int i = scanner.nextInt();
		int result = i % 2;
		System.out.println((result == 0) ? "입력한 수는 짝수입니다." : "입력한 수는 홀수입니다.");
		scanner.close();
	}
}

package com.lec.condition;

import java.util.Scanner;

// 두 수를 입력받아 어떤 수가 더 큰지 출력하시오.
public class Ex02_if {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 수를 입력하세요: ");
		int num1 = scanner.nextInt();
		System.out.print("첫번째 수를 입력하세요: ");
		int num2 = scanner.nextInt();
		if (num1 > num2) {
			System.out.printf("첫번째 수 (%d)가 %d만큼 더 큽니다.", num1, (num1 - num2));
		} else if (num1 < num2) {
			System.out.printf("두번째 수 (%d)가 %d만큼 더 큽니다.", num2, (num2 - num1));
		} else {
			System.out.println("같은 수 입니다.");
		} // if
	} // main
} // class

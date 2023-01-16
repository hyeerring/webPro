package com.lec.conditionQuiz;

import java.util.Scanner;

//(Quiz 1) 수를 입렵받아 절대값을 출력하는 프로그램
public class Quiz01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하세요: ");
		int i = scanner.nextInt();
		if (i >= 0) {
			System.out.println(i);
		} else if (i < 0) {
			System.out.println(-i);
		}
	}
}

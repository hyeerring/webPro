package com.lec.conditionQuiz;

import java.util.Scanner;

//(Quiz05) 현재 몇 월인지를 키보드로부터 입력받아 계절을 출력하는 프로그램을 구현하세요.
public class Quiz05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("계절을 알고 싶은 월의 수를 입력하세요: ");
		int mon = scanner.nextInt();
		switch (mon) {
		case 12:
		case 1:
		case 2:
			System.out.println("겨울");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println("봄");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("여름");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("겨울");
			break;
		default:
			System.out.println("1에서 12사이의 숫자를 넣어주세요.");
			break;
		}
	}
}

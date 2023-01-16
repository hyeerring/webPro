package com.lec.conditionQuiz;

import java.util.Scanner;

//(Quiz 4) 컴퓨터와 가위바위보 게임을 하는 프로그램을 구현하시오.
// 단, 사용자는 (가위 = 0, 바위 = 1, 보 = 2)를 입력하여 게임을 진행합니다.
public class Quiz04 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("가위(0), 바위(1), 보(2) 중 하나를 선택하세요: ");
		int you = scanner.nextInt(); // 0, 1, 2
		if (you == 0) {
			System.out.println("가위를 냈습니다.");
			int com = (int) (Math.random() * 100);
			switch (com % 3) {
			case 0:
				System.out.println("상대방은 가위를 냈습니다.\n비겼습니다.");
				break;
			case 1:
				System.out.println("상대방은 바위를 냈습니다.\n졌습니다.");
				break;
			case 2:
				System.out.println("상대방은 보를 냈습니다.\n이겼습니다.");
				break;
			}
		} else if (you == 1) {
			System.out.println("바위를 냈습니다.");
			int com = (int) (Math.random() * 100);
			switch (com % 3) {
			case 0:
				System.out.println("상대방은 가위를 냈습니다.\n이겼습니다.");
				break;
			case 1:
				System.out.println("상대방은 바위를 냈습니다.\n비겼습니다.");
				break;
			case 2:
				System.out.println("상대방은 보를 냈습니다.\n졌습니다.");
				break;
			}
		} else if (you == 2) {
			System.out.println("보를 냈습니다.");
			int com = (int) (Math.random() * 100);
			switch (com % 3) {
			case 0:
				System.out.println("상대방은 가위를 냈습니다.\n졌습니다.");
				break;
			case 1:
				System.out.println("상대방은 바위를 냈습니다.\n이겼습니다.");
				break;
			case 2:
				System.out.println("상대방은 보를 냈습니다.\n비겼습니다.");
				break;
			}
		} else {
			System.out.println("가위, 바위, 보만 입력 가능합니다. 다시 입력하세요.");
		}
	} // main
} // class

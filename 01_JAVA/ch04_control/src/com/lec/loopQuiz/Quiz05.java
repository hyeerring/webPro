package com.lec.loopQuiz;

import java.util.Scanner;

// (Homework 1)컴퓨터와 가위바위보 게임을 -1을 입력할때까지 무한반복하는 게임을 작성하시오.

// 사용자는 (가위 = 0, 바위 = 1, 보 = 2, 종료 -1)를 입력하여 게임을 진행합니다.

public class Quiz05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int you, computer;
		while (true) {
			System.out.println("가위(0),바위(1),보(2) 중 하나를 선택하세요(종료:-1) ");
			you = scanner.nextInt();
			if (you == -1)
				break;
			computer = (int) (Math.random() * 3);
			String computerStr = (computer == 0) ? "가위" : (computer == 1) ? "바위" : "보자기";
			String youStr = (you == 0) ? "가위" : (you == 1) ? "바위" : "보자기";
			if (you < -1 || you > 2) {
				System.out.println("가위(0),바위(1),보(2) 중 하나");
			} else {
				if ((you + 2) % 3 == computer) {
					System.out.printf("당신은 %s, 컴퓨터는 %s. 당신이 이겼어요!\n", youStr, computerStr);
				} else if ((you + 1) % 3 == computer) {
					System.out.printf("당신은 %s, 컴퓨터는 %s. 컴퓨터가 이겼어요.\n", youStr, computerStr);
				} else {
					System.out.printf("당신은 %s, 컴퓨터는 %s. 비겼어요.\n", youStr, computerStr);
				}
			}
		} // while
		scanner.close();
		System.out.println("BYE");
	}// main
}// class
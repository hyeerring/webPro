package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("가위(0), 바위(1), 보(2) 중 하나를 선택하세요: ");
		int you = scanner.nextInt(); // 0, 1, 2
		if (you == 0) {
			System.out.println("당신은 가위");
		} else if (you == 1) {
			System.out.println("당신은 가위");
		} else if (you == 2) {
			System.out.println("당신은 보");
		}
	}
}

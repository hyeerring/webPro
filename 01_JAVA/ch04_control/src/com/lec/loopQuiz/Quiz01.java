package com.lec.loopQuiz;

// (Quiz 1)1~10까지의 곱을 구해보자
public class Quiz01 {
	public static void main(String[] args) {
		int result = 1;
		for (int i = 1; i <= 10; i++) {
			result *= i;
		}
		System.out.println("1부터 10까지의 곱은 " + result + "이다.");

	}
}

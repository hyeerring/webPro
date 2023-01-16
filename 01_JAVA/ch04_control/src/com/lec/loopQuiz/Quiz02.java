package com.lec.loopQuiz;

//(Quiz 2) 1~10까지 숫자 중 짝수 또는 홀수의 합을 구해보자
public class Quiz02 {
	public static void main(String[] args) {
		int tot = 0;
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1)
				tot += i;
		}
		System.out.println("1부터 10까지의 숫자 중 홀수의 합은 " + tot + "이다.");
	}
}

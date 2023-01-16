package com.lec.quiz;
//(Quiz 5) 국어, 영어, 수학 점수를 사용자에게 입력받아, 각 점수를 출력하고

//총점, 평균(소수점2자리까지) 출력하는 프로그램을 구현하시오.

import java.util.Scanner;

public class Quiz05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("국어 점수: ");
		int kor = scanner.nextInt();
		System.out.print("영어 점수: ");
		int eng = scanner.nextInt();
		System.out.print("수학 점수: ");
		int mat = scanner.nextInt();
		int sum = kor + eng + mat;
		double avg = sum / 3.;
		System.out.printf("국어 = %d, 영어 = %d, 수학 = %d\n", kor, eng, mat);
		System.out.printf("총점 = %d, 평균 = %.2f\n", sum, avg);
		scanner.close();
	}
}

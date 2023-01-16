package com.lec.quiz;

public class Example {
	public static void main(String[] args) {
		// 국어, 영어, 수학 점수 할당
		// 점수들 출력
		// 총점, 평균
		int kor = 100;
		int eng = 100;
		int mat = 50;
		double a = kor + eng + mat; // 총점
		System.out.println("국어 =" + kor);
		System.out.println("영어 =" + eng);
		System.out.println("수학 =" + mat);

		System.out.println("국어\t영어\t수학");
		System.out.printf("%d \t %d \t %d\n", kor, eng, mat);

		int tot = kor + eng + mat; // 총점
		// double avg = tot / 3;
		// double avg = tot / 3.0;
		double avg = (double) tot / 3;
		System.out.println("국어 : " + kor + "\t영어 : " + eng + "\t수학 : " + mat);
		System.out.printf("총점 : %d\t평균 : %.2f\n", tot, avg);
	}
}

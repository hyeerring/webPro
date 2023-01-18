package com.lec.ex01_student;

public class StudentMain {
	public static void main(String[] args) {
		Student s1 = new Student("정우성", 90, 90, 90);
		Student s2 = new Student("김하늘", 90, 90, 91);
		Student s3 = new Student("황정민", 80, 80, 90);
		Student s4 = new Student("강동원", 80, 90, 90);
		Student s5 = new Student("유아인", 70, 70, 90);
		Student[] students = { s1, s2, s3, s4, s5 };
		String[] title = { "이름", "국어", "영어", "수학", "총점", "평균" };
		int[] total = new int[5]; // 0번 idx: 국어누적, 1번 idx:영어누적 ... 4번 idx: 평균누적

		line('■', 60);
		System.out.println("\t\t\t   성적표");
		line('-', 60);
		for (String t : title) {
			System.out.print("\t" + t);
		}
		System.out.println(); // 개행
		line('-', 60);
		for (Student student : students) {
			System.out.print(student.infoString());
			// student.infoPrint();
			// 총점변수(국, 영, 수, 총, 평) 누적
			total[0] += student.getKor();
			total[1] += student.getEng();
			total[2] += student.getMat();
			total[3] += student.getTot();
			// total[4] += total[4] + student.getAvg(); 평균누적 에러
			total[4] += student.getAvg();
		}
		line('=', 60);
		System.out.print("\t총점");
		for (int t : total) {
			System.out.print("\t" + t);
		}
		System.out.print("\n\t평균");
		for (int t : total) {
			// System.out.print("\t%.1f", t/5.0);
			System.out.print("\t" + (double)t / students.length);
		}
		System.out.println();
		line('■', 60);
	} // main

	private static void line(char c, int j) {
		for (int i = 1; i < j; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
} // class

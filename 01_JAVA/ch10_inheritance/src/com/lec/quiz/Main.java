package com.lec.quiz;

public class Main {

	public static void main(String[] args) {

		Person st1 = new Student("A01", "강유미", "JAVA반");
		Person st2 = new Student("A02", "홍길동", "C++반");
		Person st3 = new Student("A02", "김철수", "C++반");
		Person sf1 = new Staff("S01", "유길동", "운영지원팀");
		Person sf2 = new Staff("S01", "유길동", "취업지원팀");
		Person ga1 = new Gangsa("G01", "이길동", "객체지향");
		Person ga2 = new Gangsa("G02", "김길동", "디자인");
		Person[] p = { st1, st2, st3, sf1, sf2, ga1, ga2 };

		for (Person pp : p) {
			System.out.println(pp.print());

		}

	}

}

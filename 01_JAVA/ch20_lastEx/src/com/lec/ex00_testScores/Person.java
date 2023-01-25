package com.lec.ex00_testScores;

import java.util.ArrayList;
import java.util.Scanner;

public class Person {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PersonDao dao = PersonDao.getINSTANCE();
		String fn;
		ArrayList<String> jobs = dao.jnameList();
		
		do {
			System.out.print("1:입력 || 2:직업별 조회 || 3:전체 조회 || 그외:종료 || ");
			fn = sc.next();
			switch (fn) {
			case "1":
				System.out.print("이름을 입력하세요: ");
				String pname = sc.next();
				System.out.print("직업을 입력하세요: ");
				String jname = sc.next();
				System.out.print("국어 점수를 입력하세요: ");
				int kor = sc.nextInt();
				System.out.print("영어 점수를 입력하세요: ");
				int eng = sc.nextInt();
				System.out.print("수학 점수를 입력하세요: ");
				int mat = sc.nextInt();
				dao.insertPerson(new PersonDto(pname, jname, kor, eng, mat));
				break;

			case "2":
				System.out.println("검색할 직업" + jobs + "를 입력하세요: ");
				jname = sc.next();
				ArrayList<PersonDto> dtos = dao.selectJname(jname);
				if (dtos.isEmpty()) {
					System.out.println("해당 직업의 사람이 없습니다.");
				} else {
					for (PersonDto d : dtos) {
						System.out.println(d);
					}
				}
				break;
				
			case "3":
				dtos = dao.sellectAll();
				if (dtos.isEmpty()) {
					System.out.println("등록된 사람이 없습니다.");
				} else {
					for (PersonDto d : dtos) {
						System.out.println(d);
					}
				}
				break;
			}
		} while (fn.equals("1")||fn.equals("2")||fn.equals("3"));
		System.out.println("프로그램 종료");
	}
}

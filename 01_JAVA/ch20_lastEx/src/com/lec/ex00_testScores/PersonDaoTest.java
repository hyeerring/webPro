package com.lec.ex00_testScores;

import java.util.ArrayList;

public class PersonDaoTest {
	public static void main(String[] args) {
		
		PersonDao dao = PersonDao.getINSTANCE();
		
//		System.out.println("-------- 1번 TEST --------");
//		PersonDto dto = new PersonDto("홍길동", "배우", 90, 95, 98);
//		int result = dao.insertPerson(dto);

		System.out.println("-------- 2번 TEST --------");
		ArrayList<PersonDto> dtos = dao.selectJname("배우");
		if(dtos.isEmpty()) {
			System.out.println("해당 직업의 사람이 등록되지 않았습니다");
		}else {
			for(PersonDto d : dtos) {
				System.out.println(d);
			}
		}
		
		System.out.println("-------- 3번 TEST --------");
		dtos = dao.sellectAll();
		if(dtos.isEmpty()) {
			System.out.println("등록된 사람이 없습니다.");
		}else {
			for(PersonDto d : dtos) {
				System.out.println(d);
			}//for
		}//if
	}//main
}
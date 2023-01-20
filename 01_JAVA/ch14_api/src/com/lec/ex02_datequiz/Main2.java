package com.lex.ex02_datequiz;

public class Main2 {

	public static void main(String[] args) {
		Sawon2[] employee = {new Sawon2("220001","김길동", Dept.COMPUTER),
				new Sawon2("220002","이길동", Dept.PLANNING),
				new Sawon2("220003","삼길동", Dept.DESIGN),
				new Sawon2("220004","사길동", Dept.ACCOUNTING, 2022, 12, 15),
				new Sawon2("220005","오길동", Dept.HUMANRESOURCES, 2020, 02, 02)};
		for(int i = 0; i < employee.length ; i++) {
			System.out.println(employee[i]);
		}
		System.out.println("------------------------------------------------------------");
		for(Sawon2 emp : employee) {
			System.out.println(emp);
		}
	
	}

}
